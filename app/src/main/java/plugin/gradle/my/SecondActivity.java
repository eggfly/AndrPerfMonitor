package plugin.gradle.my;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import plugin.gradle.my.dummy.DummyContent;

/**
 * Created by ZhouKeWen on 17/3/31.
 */
public class SecondActivity extends AppCompatActivity {

    private byte[] a = new byte[8024000];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        tx.add(R.id.id_content, blankFragment, "ONE");
        tx.commit();

        blankFragment.onLowMemory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DummyContent d = new DummyContent();
        d.sleep();
    }

}
