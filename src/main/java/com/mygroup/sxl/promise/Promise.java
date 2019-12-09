package com.mygroup.sxl.promise;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shenxl
 * @Date: 2019/11/20 17:31
 * @Version 1.0
 * @description：${description}
 */
@Slf4j
public class Promise {


    private static final String TAG = "Promise";
    private OnSuccessListener onSuccessListener;
    private OnErrorListener onErrorListener;
    private Promise child;
    private boolean isResolved;
    private Object resolvedObject;
    private Object tag;


    public Promise() {
    }

    public static Promise all(Promise... list) {
        Promise p = new Promise();
        if (list == null || list.length <= 0) {
            System.out.println("Promise list should not be empty!");
            p.resolve(new ArrayList<>());
            return p;
        }

        if (list != null && list.length > 0) {
            new Runnable() {
                int completedCount = 0;
                Object result[] = new Object[list.length];

                @Override
                public void run() {
                    for (int i = 0; i < list.length; i++) {
                        Promise promise = list[i];
                        promise.setTag(i);
                        promise.then(res -> {
                            result[(int) promise.getTag()] = res;
                            completed(null);
                            return res;
                        }).error(err -> completed(err));
                    }
                }

                private void completed(Object err) {
                    completedCount++;
                    if (err != null) {
                        p.reject(err);
                    } else if (completedCount == list.length) {
                        p.resolve(result);
                    }
                }

            }.run();
        } else {
            System.out.println("Promises should not be empty!");
            p.resolve(new ArrayList<>());
        }


        return p;
    }

    public static Promise series(List<?> list, OnSuccessListener listener) {
        Promise p = new Promise();
        if (list == null || listener == null || list.size() <= 0) {
            System.out.println("Arguments should not be NULL!");
            return null;
        }

        new Runnable() {
            int index = -1;
            int completedCount = 0;
            ArrayList<Object> result = new ArrayList<>(list.size());

            @Override
            public void run() {
                index++;
                if (index < list.size()) {
                    // for (int i = 0; i < list.size(); i++) {
                    handleSuccess(index, list.get(index));
                    //}
                } else {
                    p.resolve(result);
                }
            }

            private void handleSuccess(int index, Object object) {
                Object res = listener.onSuccess(object);
                result.add(index, res);
                if (res instanceof Promise) {
                    Promise pro = (Promise) res;
                    pro.setTag(index);
                    pro.then(r -> {
                        result.set((int) pro.getTag(), r);
                        if (!completed(null)) {
                            run();
                        }
                        return r;
                    }).error(err -> completed(err));
                } else {
                    completed(null);
                }

            }

            private boolean completed(Object err) {
                completedCount++;
                if (err != null) {
                    p.reject(err);
                } else if (completedCount == list.size()) {
                    p.resolve(result);
                    return true;
                }
                return false;
            }

        }.run();

        return p;
    }

    public static Promise parallel(List<?> list, OnSuccessListener listener) {
        Promise p = new Promise();
        if (list == null || listener == null || list.size() <= 0) {
            System.out.println("Arguments should not be NULL!");
            return null;
        }

        new Runnable() {
            int completedCount = 0;
            ArrayList<Object> result = new ArrayList<>(list.size());

            @Override
            public void run() {
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        handleSuccess(i, list.get(i));
                    }
                } else {
                    p.resolve(result);
                }
            }

            private void handleSuccess(int index, Object object) {
                Object res = listener.onSuccess(object);
                result.add(index, res);
                if (res instanceof Promise) {
                    Promise pro = (Promise) res;
                    pro.setTag(index);
                    pro.then(r -> {
                        result.set((int) pro.getTag(), r);
                        completed(null);
                        return r;
                    }).error(err -> completed(err));
                } else {
                    completed(null);
                }

            }

            private void completed(Object err) {
                completedCount++;
                if (err != null) {
                    p.reject(err);
                } else if (completedCount == list.size()) {
                    p.resolve(result);
                }
            }

        }.run();

        return p;
    }

    /**
     * Call this function with your resultant value, it will be available
     * in following `then()` function call.
     *
     * @param object your resultant value (any type of data you can pass as argument
     *               e.g. int, String, List, Map, any Java object)
     * @return This will return the resultant value you passed in the function call
     */
    public Object resolve(Object object) {
        isResolved = true;
        resolvedObject = object;
        handleSuccess(child, object);
        return object;
    }

    /**
     * Call this function with your error value, it will be available
     * in following `error()` function call.
     *
     * @param object your error value (any type of data you can pass as argument
     *               e.g. int, String, List, Map, any Java object)
     * @return This will return the error value you passed in the function call
     */
    public Object reject(Object object) {
        handleError(object);

        return object;
    }

    /**
     * After executing asynchronous function the result will be available in the success listener
     * as argument.
     *
     * @param listener OnSuccessListener
     * @return It returns a promise for satisfying next chain call.
     */
    public Promise then(OnSuccessListener listener) {
        onSuccessListener = listener;
        child = new Promise();
        return child;
    }

    /**
     * This function must call at the end of the `then()` cain, any `reject()` occurs in
     * previous async execution this function will be called.
     *
     * @param listener
     */
    public void error(OnErrorListener listener) {
        onErrorListener = listener;
    }

    private void handleSuccess(Promise child, Object object) {
        if (onSuccessListener != null) {
            Object res = onSuccessListener.onSuccess(object);
            if (res != null) {
                if (res instanceof Promise) {
                    if (child != null) {
                        Promise p = (Promise) res;
                        p.onSuccessListener = child.onSuccessListener;
                        p.onErrorListener = child.onErrorListener;
                        p.child = child.child;
                        child = p;
                    }
                } else if (child != null) {
                    child.resolve(res);
                }
            } else {
                if (child != null) {
                    child.resolve(res);
                }
            }
        }
    }

    private void handleError(Object object) {
        if (onErrorListener != null) {
            onErrorListener.onError(object);
        } else if (child != null) {
            child.reject(object);
        }
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }


    public interface OnSuccessListener {
        Object onSuccess(Object object);
    }

    public interface OnErrorListener {
        void onError(Object object);
    }
}
