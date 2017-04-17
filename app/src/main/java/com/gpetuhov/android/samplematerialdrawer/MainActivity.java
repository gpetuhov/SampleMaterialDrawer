package com.gpetuhov.android.samplematerialdrawer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Drawer drawer;
    private PrimaryDrawerItem item1;
    private SecondaryDrawerItem item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MaterialDrawer is used best with Toolbar, not ActionBar,
        // so we have to switch our AppCompatActivity to Toolbar.
        // To do this, we use Theme.AppCompat.Light.NoActionBar in styles.xml
        // and add Toolbar widget to the activity layout xml file.
        // Now we can use Toolbar to our activity.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Menu item 1");
        item2 = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName("Menu item 2")
                .withIcon(FontAwesome.Icon.faw_camera)
                .withBadge("15")
                .withBadgeStyle(new BadgeStyle().withColor(Color.RED).withTextColor(Color.WHITE))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Toast.makeText(MainActivity.this, "Clicked on item 2", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer();
                        return true;
                    }
                });

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withSelectedItem(-1)
                .withToolbar(toolbar)
                .withTranslucentNavigationBarProgrammatically(true)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("Another menu item")
                )
                .build();
    }
}
