package com.example.j2objc_demo.ios.UILabelDemo;

import apple.coregraphics.CGPoint;
import apple.coregraphics.CGRect;
import apple.coregraphics.CGSize;
import apple.uikit.UIColor;
import apple.uikit.UIFont;
import apple.uikit.UILabel;
import apple.uikit.UIViewController;


public class UILabelDemoViewController extends UIViewController{

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        UILabel label = new UILabel(CGRect.create(CGPoint.create(20, 50), CGSize.create(300, 100)));
        label.setText("Hello world!");
        label.setFont(UIFont.getSystemFont(20));
        getView().setBackgroundColor(UIColor.white());
        getView().addSubview(label);
    }
}
