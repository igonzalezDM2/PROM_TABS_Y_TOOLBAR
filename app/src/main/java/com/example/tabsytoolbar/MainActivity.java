package com.example.tabsytoolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final Contacto[] CONTACTOS = new Contacto[] {
            new Contacto(R.drawable.ruka, "Ruka", "666"),
            new Contacto(R.drawable.nezuko, "Nezuko", "777"),
            new Contacto(R.drawable.yui, "Ruka", "888")
    };

    private static final Chat[] CHATS = new Chat[] {
            new Chat(CONTACTOS[0], "hola xd", new Date()),
            new Chat(CONTACTOS[1], "adios xd", new Date()),
            new Chat(CONTACTOS[2], "jeje xd", new Date())
    };

    private static final Llamada[] LLAMADAS = new Llamada[] {
            new Llamada(CONTACTOS[0], new Date(), 20),
            new Llamada(CONTACTOS[1], new Date(), 12),
            new Llamada(CONTACTOS[1], new Date(), 5)
    };

    Toolbar toolbar;
    TabLayout tabLayout;
    MenuItem otro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter());

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (otro != null) {
                    int posicion = tab.getPosition();
                    switch (posicion) {
                        case 0:
                            otro.setIcon(R.drawable.contactos);
                            break;
                        case 1:
                            otro.setIcon(R.drawable.chat);
                            break;
                        case 2:
                            otro.setIcon(R.drawable.llamada);
                            break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        otro = toolbar.getMenu().findItem(R.id.variable);
        return true;
    }

    public class PageAdapter extends PagerAdapter {

        private LinearLayout pestanaLlamadas, pestanaChats, pestanaContactos;
        private final int[] pestanas = {R.string.tab1, R.string.tab2, R.string.tab3};

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getString(pestanas[position]);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page = null;
            switch (position) {
                case 0:
                    if (pestanaContactos == null) {
                        AdaptadorContactos adaptadorContactos = new AdaptadorContactos(MainActivity.this, CONTACTOS);
                        pestanaContactos = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.listview, container, false);
                        ListView listview = (ListView) pestanaContactos.findViewById(R.id.lvWaifus);
                        listview.setAdapter(adaptadorContactos);

                    }
                    page = pestanaContactos;
                    break;
                case 1:
                    if (pestanaChats == null) {
                        AdaptadorChats adaptadorChats = new AdaptadorChats(MainActivity.this, CHATS);
                        pestanaChats = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.listview, container, false);
                        ListView listview = (ListView) pestanaChats.findViewById(R.id.lvWaifus);
                        listview.setAdapter(adaptadorChats);
                    }
                    page = pestanaChats;
                    break;
                default:
                    if (pestanaLlamadas == null) {
                        AdaptadorLlamadas adaptadorLlamadas = new AdaptadorLlamadas(MainActivity.this, LLAMADAS);
                        pestanaLlamadas = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.listview, container, false);
                        ListView listview = (ListView) pestanaLlamadas.findViewById(R.id.lvWaifus);
                        listview.setAdapter(adaptadorLlamadas);
                    }
                    page = pestanaLlamadas;
                    break;
            }
            container.addView(page, 0);
            return page;
        }


    }
}