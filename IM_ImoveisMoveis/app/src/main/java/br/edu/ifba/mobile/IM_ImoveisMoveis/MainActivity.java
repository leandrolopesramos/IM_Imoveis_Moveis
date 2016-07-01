package br.edu.ifba.mobile.IM_ImoveisMoveis;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;
import br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos.FragmentoCadastroCasa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos.FragmentoListaApartamentos;
import br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos.FragmentoListaCasas;
import br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos.FragmentoCadastroApartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos.FragmentoTelaInicial;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     *
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        paginador = (ViewPager) findViewById(R.id.container);
        paginador.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(paginador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        paginador.addOnPageChangeListener(this);

        FachadaBD.criarInstancia(this.getApplicationContext());
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_imoveis, menu);
        return true;
    }*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position == 1){
            FragmentoListaCasas.getInstancia().atualizar();
        } else if (position == 2){
            FragmentoCadastroCasa.getInstancia().exibirCasaSelecionada();
        }else if (position == 3){
            FragmentoListaApartamentos.getInstancia().atualizar();
        }else if (position == 4){
            FragmentoCadastroApartamento.getInstancia().exibirApartamentoSelecionado();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag = null;

            switch (position){
                case 0:
                    frag = FragmentoTelaInicial.getInstancia();
                    break;

                case 1:
                    frag = FragmentoListaCasas.getInstancia();
                    break;

                case 2:
                    frag = FragmentoCadastroCasa.getInstancia();
                    break;
                case 3:
                    frag = FragmentoListaApartamentos.getInstancia();
                    break;

                case 4:
                    frag = FragmentoCadastroApartamento.getInstancia();
                    break;

            }

            return frag;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Tela Inicial";
                case 1:
                    return "Lista Casas";
                case 2:
                    return "Cad. Casas";
                case 3:
                    return "Lista Aptos";
                case 4:
                    return "Cad. Aptos";
            }
            return null;
        }
    }
}
