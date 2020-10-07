package com.example;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.jni.JNIRuntimeAccess;
import org.graalvm.nativeimage.hosted.Feature;

@AutomaticFeature
public class JNIRegistrationFeature implements Feature {
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        try {
            JNIRuntimeAccess.register(String.class);
            JNIRuntimeAccess.register(String.class.getDeclaredMethod("getBytes"));
        } catch (NoSuchMethodException e) {
        }
    }
}