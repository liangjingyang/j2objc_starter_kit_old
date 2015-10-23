package com.example.j2objc_demo.ios;


import java.util.ArrayList;

import apple.coregraphics.CGPoint;
import apple.coregraphics.CGRect;
import apple.coregraphics.CGSize;
import apple.foundation.NSIndexPath;
import apple.uikit.NSIndexPathExtensions;
import apple.uikit.UIColor;
import apple.uikit.UIFont;
import apple.uikit.UILabel;
import apple.uikit.UIScreen;
import apple.uikit.UITableView;
import apple.uikit.UITableViewCell;
import apple.uikit.UITableViewCellAccessoryType;
import apple.uikit.UITableViewDataSource;
import apple.uikit.UITableViewDataSourceAdapter;
import apple.uikit.UITableViewDelegate;
import apple.uikit.UITableViewDelegateAdapter;
import apple.uikit.UITableViewStyle;
import apple.uikit.UIView;
import apple.uikit.UIViewAutoresizing;
import apple.uikit.UIViewController;


public class ViewController extends UIViewController {

    private String mTitle = "J2objc Demo";
    private final ArrayList<String> mDemoTitles;
    private UITableViewDelegate mTableViewDelegate;
    private UITableViewDataSource mTableViewDataSource;

    public ViewController() {
        this.setTitle(mTitle);
        mDemoTitles = new ArrayList<>();
        mDemoTitles.add("Label");
    }

    public void loadView() {
        mTableViewDelegate = new TableViewDelegate();
        mTableViewDataSource = new TableViewDataSource();

        UIView view = new UIView(UIScreen.getMainScreen().getBounds());
        view.setBackgroundColor(UIColor.white());
        view.autoresizesSubviews();

        UITableView rootTableView = new UITableView(view.getFrame(), UITableViewStyle.Plain);
        rootTableView.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight | UIViewAutoresizing.FlexibleWidth);
        rootTableView.setDelegate(mTableViewDelegate);
        rootTableView.setDataSource(mTableViewDataSource);

        view.addSubview(rootTableView);
        setView(view);
    }

    public void viewWillAppear(boolean animated) {
        getNavigationController().setDelegate(null);
        super.viewWillAppear(animated);
    }

    public void viewDidLoad() {
        super.viewDidLoad();
//        UILabel label = new UILabel(CGRect.create(CGPoint.Zero(), CGSize.create(300, 100)));
//        label.setText("Hello world!");
//        label.setFont(UIFont.getSystemFont(20));
//        getView().setBackgroundColor(UIColor.white());
//        getView().addSubview(label);
    }

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }


    public class TableViewDelegate extends UITableViewDelegateAdapter {
        @Override
        public void didSelectRow(UITableView tableView, NSIndexPath indexPath) {
            tableView.deselectRow(indexPath, true);
            UIViewController demoViewController = null;
            int row = (int) NSIndexPathExtensions.getRow(indexPath);
            switch (row) {
                case 0:
                    System.out.println("first demo");
                    break;
                default:
                    break;
            }
            if (demoViewController != null) {
                getNavigationController().pushViewController(demoViewController, true);
            }
        }
    }

    public class TableViewDataSource extends UITableViewDataSourceAdapter {
        @Override
        public long getNumberOfSections(UITableView tableView) {
            return 1;
        }

        @Override
        public long getNumberOfRowsInSection(UITableView tableView, long section) {
            return mDemoTitles.size();
        }

        @Override
        public UITableViewCell getCellForRow(UITableView tableView, NSIndexPath indexPath) {
            UITableViewCell tableViewCell = new UITableViewCell();
            int row = (int) NSIndexPathExtensions.getRow(indexPath);
            tableViewCell.getTextLabel().setText(mDemoTitles.get(row));
            tableViewCell.setAccessoryType(UITableViewCellAccessoryType.DisclosureIndicator);
            return tableViewCell;
        }
    }
}

