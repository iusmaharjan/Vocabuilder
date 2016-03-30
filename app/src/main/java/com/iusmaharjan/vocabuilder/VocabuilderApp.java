package com.iusmaharjan.vocabuilder;

import android.app.Application;
import android.util.Log;

import timber.log.Timber;

public class VocabuilderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    /** A tree which logs important information for crash reporting. */
    private static class CrashReportingTree extends Timber.Tree {
        @Override protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            //CrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    //CrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    //CrashLibrary.logWarning(t);
                }
            }
        }
    }
}
