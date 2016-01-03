package com.webschik.reactnativeandroidspinner;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.bridge.ReadableArray;

public class SpinnerManager extends SimpleViewManager<Spinner> {
    public static final String REACT_CLASS = "SpinnerAndroid";

    private static class SpinnerShadowNode extends LayoutShadowNode implements CSSNode.MeasureFunction {
        private int mWidth;
        private int mHeight;
        private boolean mMeasured;

        private SpinnerShadowNode() {
            setMeasureFunction(this);
        }

        @Override
        public void measure(CSSNode node, float width, MeasureOutput measureOutput) {
            if (!mMeasured) {
                Spinner reactSwitch = new Spinner(getThemedContext());
                final int spec = View.MeasureSpec.makeMeasureSpec(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    View.MeasureSpec.UNSPECIFIED
                );

                reactSwitch.measure(spec, spec);
                mWidth = reactSwitch.getMeasuredWidth();
                mHeight = reactSwitch.getMeasuredHeight();
                mMeasured = true;
            }

            measureOutput.width = mWidth;
            measureOutput.height = mHeight;
        }
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public Spinner createViewInstance(ThemedReactContext context) {
        return new Spinner(context);
    }

    @ReactProp(name = "values")
    public void setValues(Spinner view, ReadableArray values) {
        view.setValues(values);
    }

    @ReactProp(name = "selected")
    public void setSelected(Spinner view, int selected) {
        view.setSelected(selected);
    }

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        return new SpinnerShadowNode();
    }

    @Override
    public Class getShadowNodeClass() {
        return SpinnerShadowNode.class;
    }
}
