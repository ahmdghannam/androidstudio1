package com.medo.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.BiConsumerSingleObserver;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cold
//        Observable<Long> cold= Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS);
//        cold.subscribe(i-> Log.d("MainActivity","oncreate : one : "+i));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        cold.subscribe(i-> Log.d("MainActivity","oncreate : scd : "+i));

        // hot by cold
//        ConnectableObservable<Long> hot= ConnectableObservable.intervalRange(0,5,0,1, TimeUnit.SECONDS).publish();
//        hot.connect();
//        hot.subscribe(i-> Log.d("MainActivity","oncreate : one : "+i));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        hot.subscribe(i-> Log.d("MainActivity","oncreate : scd : "+i));


//        hot type 1
//        PublishSubject<String>subject=PublishSubject.create();
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student First "+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student second "+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
//        hot type 3
//        ReplaySubject<String>subject=ReplaySubject.create();
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student First "+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student second "+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
//        AsyncSubject<String> subject=AsyncSubject.create();
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student First "+i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i->Log.d("MainActivity","onCreate Student second "+i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);
//           subject.onComplete();
//        Observer observer=new Observer() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@org.jetbrains.annotations.NotNull Object o) {
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        SingleObserver observer=new SingleObserver() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NotNull Object o) {
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        };
//        MaybeObserver observer =new MaybeObserver() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NotNull Object o) {
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        CompletableObserver observer=new CompletableObserver() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        };
        Observable observable=Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                for (int i = 0; i < 5; i++) {
                    if(i==3)
                emitter.onNext(3/0);
              else
                  emitter.onNext(i);

            }
                emitter.onComplete();
            }
        });
//        Observable observable=Observable.just(0,1,2,3,4,5,6,7,8,9);
//        Integer []list=new Integer[5];
//        for (int i = 0; i < 5; i++) {
//            list[i]=i;
//        }
//        Observable observable=Observable.fromArray(list).repeat(2);
//        Observable observable=Observable.range(0,5);
        Observer observer=new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG,"on subscribe :");
            }

            @Override
            public void onNext(@NotNull Object o) {
                Log.d(TAG,"on Next :"+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"on error :"+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"on Complete :");
            }
        };
            observable.subscribe(observer);

    }

    private void sleep(int i) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}