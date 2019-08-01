package com.gerdi.doadoa.View;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.gerdi.doadoa.Database.AppDatabase;
import com.gerdi.doadoa.Entity.Doa;
import com.gerdi.doadoa.R;
import com.gerdi.doadoa.View.Fragment.FragmentAbout;
import com.gerdi.doadoa.View.Fragment.FragmentBuku;
import com.gerdi.doadoa.View.Fragment.FragmentFilm;
import com.gerdi.doadoa.View.Fragment.FragmentMusik;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    private List<Doa> doaList;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!restorePrefData()) {
            addData();
            savePrefsData();
        }

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.bottom_navigation_items);
        fragmentManager = getSupportFragmentManager();

        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.main_container, new FragmentBuku()).commit();

        //Memberikan listener saat menu item di bottom navigation diklik
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_buku:
                        fragment = new FragmentBuku();
                        break;
                    case R.id.menu_musik:
                        fragment = new FragmentMusik();
                        break;
                    case R.id.menu_film:
                        fragment = new FragmentFilm();
                        break;
                    case R.id.menu_about:
                        fragment = new FragmentAbout();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;

            }
        });
    }

    private boolean restorePrefData() {
        SharedPreferences pref1 = this.getSharedPreferences("myPrefs1",MODE_PRIVATE);
        Boolean isFragmentHeroOpnendBefore = pref1.getBoolean("isHeroOpnend",false);
        return  isFragmentHeroOpnendBefore;
    }
    private void savePrefsData() {
        SharedPreferences pref = this.getSharedPreferences("myPrefs1",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isHeroOpnend",true);
        editor.commit();
    }

    private void addData(){
        db = Room.databaseBuilder(this, AppDatabase.class,"Doa").allowMainThreadQueries().build();

        Doa doa = new Doa();
        doa.setNamaDoa("Bacaan Harian");
        doa.setBacaDoa("لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ");
        doa.setLatinDoa("laa ilaaha illallahu wahdahuu laa syariika lahuu, lahul mulku wa lahul hamdu wa huwa 'alaa kulli syai'in qadir");
        doa.setArtiDoa("Tidak ada ilah (yang berhaq disembah) selain Allah Yang Maha Tunggal tidak ada sekutu bagi-Nya. Milik-Nya kerajaan dan bagi-Nya segala puji dan Dia Maha Kuasa atas segala sesuatu");
        doa.setCarabacaDoa("dibaca 100X dalam sehari");
        doa.setKeutamaanDoa("pahala seperti membebaskan sepuluh orang budak, ditetapkan baginya seratus hasanah (kebaikan) dan dijauhkan darinya seratus keburukan dan baginya ada perlindungan dari (godaan) setan pada hari itu hingga petang dan tidak ada orang yang lebih baik amalnya dari orang yang membaca doa ini kecuali seseorang yang mengamalkan lebih banyak dari itu");
        doa.setSumberDoa("HR. Buhari");
        doa.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa);

        Doa doa2 = new Doa();
        doa2.setNamaDoa("Bacaan Harian 2");
        doa2.setBacaDoa("سُبْحَانَ اللَّهِ وَبِحَمْدِه");
        doa2.setLatinDoa("Subhanallah wabihamdihi");
        doa2.setArtiDoa("Maha suci Allah dan segala pujian hanya untuk-Nya");
        doa2.setCarabacaDoa("dibaca 100X dalam sehari");
        doa2.setKeutamaanDoa("kesalahan-kesalahannya akan terampuni walaupun sebanyak buih di lautan");
        doa2.setSumberDoa("H.R. Bukhori 6405");
        doa2.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa2);

        Doa doa3 = new Doa();
        doa3.setNamaDoa("Doa Pagi Sore");
        doa3.setBacaDoa("ِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ");
        doa3.setLatinDoa("BISMILLAAHILLADZII LAA YADHURRU MA'AS MIHI SYAI UN FIL ARDHI WA LAA FIS SAMAAI WA HUWAS SAMII'UL 'ALIIM");
        doa3.setArtiDoa("Dengan menyebutkan nama Allah yang tidak ada sesuatupun dengan menyebut namaNya yang membahayakan di bumi maupun di langit, dan Dia Maha Mendengar lagi Maha mengetahui");
        doa3.setCarabacaDoa("Pagi Hari 3X dan Sore Hari 3X");
        doa3.setKeutamaanDoa("Tidak akan diganggu oleh sesuatupun");
        doa3.setSumberDoa("H.R. Tirmidzi 3388\n" +
                "حسن صحيح");
        doa3.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa3);

        Doa doa4 = new Doa();
        doa4.setNamaDoa("Doa Pagi Sore 2");
        doa4.setBacaDoa("اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَهَ إِلَّا أَنْتَ خَلَقْتَنِي وَأَنَا عَبْدُكَ وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ أَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ وَأَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ وَأَعْتَرِفُ بِذُنُوبِي فَاغْفِرْ لِي ذُنُوبِي إِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْت");
        doa4.setLatinDoa("ALLAAHUMMA ANTA RABBII LAA ILAAHA ILLAA ANTA KHALAQTANII WA ANAA 'ABDUKA WA ANAA 'ALAA 'AHDIKA WA WA'DIKA MASTATHA'TU, A'UUDZU BIKA MIN SYARRI MAA SHANA'TU WA ABUU-U LAKA BINI'MATIKA 'ALAYYA WA A'TARIFU BIDZUNUUBII FAGHFIR LII DZUNUUBII, INNAHU LAA YAGHFIRUDZ DZUNUUBA ILLAA ANTA");
        doa4.setArtiDoa("Ya Allah, Engkau adalah Tuhanku, tidak ada tuhan yang berhak disembah kecuali Engaku, Engkau telah menciptakanku, dan aku adalah hambaMu, dan berada dalam perjanjian dan janjiMu semampuku. Aku berlindung kepadaMu dari keburukan apa yang telah aku perbuat, dan aku mengakui kenikmatanMu yang Engkau berikan kepadaku dan mengakui dosa-dosaku, maka ampunilah dosaku, sesungguhnya tidak ada yang dapat mengampuni dosa kecuali Engkau");
        doa4.setCarabacaDoa("-");
        doa4.setKeutamaanDoa("Tidak ada seorangpun diantara kalian yang mengucapkannya ketika sore hari kemudian datang kepadanya taqdir untuk meninggal sebelum datang pagi hari melainkan wajib baginya Surga, dan tidaklah ia mengucapkannya ketika pagi hari kemudian datang kepadanya taqdir untuk meninggal sebelum datang sore hari melainkan wajib baginya Surga");
        doa4.setSumberDoa("H.R. Tirmidzi 3393\n" +
                "حسن غريب - صحيح (الألباني)");
        doa4.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa4);

        Doa doa5 = new Doa();
        doa5.setNamaDoa("Doa Pagi Sore 3");
        doa5.setBacaDoa("سُبْحَانَ اللَّهِ 100" +
                "الْحَمْدُ لِلَّهِ 100\n" +
                "لَا إِلَهَ إِلَّا اللَّهُ 100\n" +
                "اللَّهُ أَكْبَرُ 100");
        doa5.setLatinDoa("Al HAMDULILLAAH 100X\n" +
                "LAA ILAAHA ILLALLAAH 100X\n" +
                "ALLAAHU AKBAR 100X\n");
        doa5.setArtiDoa("segala puji bagi allah, Tiada tuhan Selain Allah, Allah maha besar");
        doa5.setCarabacaDoa("dibaca Pagi dan sore");
        doa5.setKeutamaanDoa("Barang siapa yang bertasbih kepada Allah sebanyak seratus kali pada pagi hari dan seratus kali pada sore hari maka ia seperti orang yang seratus kali haji. Barang siapa bertahmid kepada Allah seratus kali pada pagi dan sore hari maka ia seperti membawa seratus kuda di jalan Allah, atau orang yang berperang seratus peperangan. Dan barang siapa yang bertahlil kepada Allah sebanyak seratus kali pada pagi hari dan seratus kali pada sore hari maka ia seperti orang yang memerdekakan budak dari anak Isma'il, dan barang siapa yang bertakbir kepada Allah sebayak seratus kali pada pagi hari dan seratus kali pada sore hari maka tidak ada orang pada hari itu yang membawa lebih banyak daripada apa yang ia bawa kecuali orang yang mengucapkan seperti itu atau lebih banyak lagi dari apa yang ia ucapkan");
        doa5.setSumberDoa("H.R. Thirmidzi 3471");
        doa5.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa5);

        Doa doa6 = new Doa();
        doa6.setNamaDoa("Selesai Dari Majelis");
        doa6.setBacaDoa("سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا أَنْتَ أَسْتَغْفِرُكَ وَأَتُوبُ إِلَيْكَ");
        doa6.setLatinDoa("SUBHAANAKALLAAHUMMA WA BIHAMDIKA ASYHADU ANLAA ILAAHA ILLAA ANTA ASTAGHFIRUKA WA ATUUBU ILAIKA");
        doa6.setArtiDoa("Maha Suci Engkau wahai Allah, dan dengan memujiMu, aku bersaksi bahwa tidak ada tuhan yang berhak di sembah melainkan Engkau, aku meminta ampun dan bertaubat kepadaMu");
        doa6.setCarabacaDoa("Selesai dari majelis");
        doa6.setKeutamaanDoa("Selesai dari majelis");
        doa6.setSumberDoa("H.R. Tirmidzi 3433");
        doa6.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa6);

        Doa doa7 = new Doa();
        doa7.setNamaDoa("Ketika Melihat Orang lain Terkena Musibah");
        doa7.setBacaDoa("الْحَمْدُ لِلَّهِ الَّذِي عَافَانِي مِمَّا ابْتَلَاكَ بِهِ وَفَضَّلَنِي عَلَى كَثِيرٍ مِمَّنْ خَلَقَ تَفْضِيلًا");
        doa7.setLatinDoa("Al HAMDULILLAAHILLAADZII 'AAFAANII MIMMAABTALAAKA BIHI WA FADHDHALANII 'ALAA KATSIIRIN MIMMAN KHALAQA TAFDHIILAN");
        doa7.setArtiDoa("segala puji bagi Allah yang telah menyelamatkanku dari musibah yang diberikan kepadamu, dan melebihkanku atas kebanyakan orang yang Dia ciptakan");
        doa7.setCarabacaDoa("Ketika melihat orang lain terkena musibah. Dibaca tapi jangan sampai yang terkena musibah mendengarnya");
        doa7.setKeutamaanDoa("diselamatkan dari ujian tersebut, apapun hal tersebut selama ia masih hidup\n");
        doa7.setSumberDoa("H.R. Tirmidzi 3431\n" +
                "غريب - حسن (الألباني)");
        doa7.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa7);

        Doa doa8 = new Doa();
        doa8.setNamaDoa("Doa Ketika Susah");
        doa8.setBacaDoa("لَا إِلَهَ إِلَّا اللَّهُ الْعَظِيمُ الْحَلِيمُ، لَا إِلَهَ إِلَّا اللهُ رَبُّ الْعَرْشِ الْعَظِيمِ، لَا إِلَهَ إِلَّا اللهُ رَبُّ السَّمَاوَاتِ وَرَبُّ الْأَرْضِ وَرَبُّ الْعَرْشِ الْكَرِيمِ");
        doa8.setLatinDoa("LAA-ILAAHA ILLALLAHUL 'ADZIIMUL HALIIM, LAA-ILAAHA ILLALLAH RABBUL'ARSYIL 'AZHIIMI LAA-ILAAHA ILLALLAH RABBUS SAMAAWAATI WARABBUL ARDLI WARABBUL'ASYIL KARIIMI");
        doa8.setArtiDoa("Tiada sesembahan yang hak selain Allah Yang Maha Mengetahui lagi Maha Bijaksana, tiada sesembahan yang hak selain Allah, Tuhan pemelihara arsy Yang Maha Agung, tiada sesembahan yang hak selain Allah Yang memelihara langit dan bumi, Tuhan pemelihara arsy yang mulia");
        doa8.setCarabacaDoa("-");
        doa8.setKeutamaanDoa("-");
        doa8.setSumberDoa("H.R. Bukhori 6346");
        doa8.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa8);

        Doa doa9 = new Doa();
        doa9.setNamaDoa("Doa Pengampunan Dosa");
        doa9.setBacaDoa("لَا إِلَهَ إِلَّا اللَّهُ وَاللَّهُ أَكْبَرُ وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّه");
        doa9.setLatinDoa("LAA ILAAHA ILLALLAAHU WALLAAHU AKBAR, WA LAA HAULA WA LAA QUWWATA ILLAA BILLAAH");
        doa9.setArtiDoa("Tidak ada tuhan yang berhak disembah kecuali Allah, dan Allah Maha Besar, tidak ada daya dan kekuatan kecuali dengan pertolongan Allah");
        doa9.setCarabacaDoa("-");
        doa9.setKeutamaanDoa("diampuni dosa-dosanya walaupun seperti buih lautan");
        doa9.setSumberDoa("H.R. Tirmidzi 3460");
        doa9.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa9);

        Doa doa10 = new Doa();
        doa10.setNamaDoa("Berat di timbangan, dan disukai Allah");
        doa10.setBacaDoa("سُبْحَانَ اللَّهِ وَبِحَمْدِهِ سُبْحَانَ اللَّهِ الْعَظِيم");
        doa10.setLatinDoa("SUBHAANALLAAHI WA BIHAMDIHI, SUBHAANALLAAHIL 'AZHIIM");
        doa10.setArtiDoa("Maha Suci Allah dan dengan memujiNya aku ada, Maha Suci Allah yang Maha Agung");
        doa10.setCarabacaDoa("-");
        doa10.setKeutamaanDoa("Dua kalimat ringan dilisan, berat ditimbangan, dan disukai Ar Rahman");
        doa10.setSumberDoa("H.R. Bukhori 7563");
        doa10.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa10);

        Doa doa11 = new Doa();
        doa11.setNamaDoa("Doa Masuk Surga");
        doa11.setBacaDoa("َرَضِيتُ بِاللَّهِ رَبًّا وَبِالْإِسْلَامِ دِينًا وَبِمُحَمَّدٍ رَسُولًا");
        doa11.setLatinDoa("RADHIITU BILLAAHI RABBAN WA BIL-ISLAAMI DIINAN WA BIMUHAMMADIN RASUULAN");
        doa11.setArtiDoa("Aku ridha Allah sebagai Tuhanku, Islam sebagai agamaku dan Muhammad sebagai rasul");
        doa11.setCarabacaDoa("-");
        doa11.setKeutamaanDoa("wajib baginya untuk masuk Surga");
        doa11.setSumberDoa("H.R. Abu Dawud 1529\n" +
                "صحيح (الألباني)");
        doa11.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa11);

        Doa doa12 = new Doa();
        doa12.setNamaDoa("Doa Pengampunan Dosa 2");
        doa12.setBacaDoa("اَسْتَغْفِرُ اللَّهَ الَّذِي لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومَ وَأَتُوبُ إِلَيْهِِ");
        doa12.setLatinDoa("ASTAGHFIRULLAAHAL LADZII LAA ILAAHA ILLAA HUWAL HAYYUL QAYYUUMU WA ATUUBU ILAIH");
        doa12.setArtiDoa("aku memohon ampun kepada Allah Dzat yang tidak ada tuhan yang berhak disembah kecuali Dia, yang Maha Hidup dan Yang terus mengurus makhlukNya, dan aku bertaubat kepadaNya");
        doa12.setCarabacaDoa("-");
        doa12.setKeutamaanDoa("Akan diampuni walaupun dia pernah lari dari medan pertempuran");
        doa12.setSumberDoa("H.R. Abu Dawud 1517" +
                "صحيح (الألباني)");
        doa12.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa12);

        Doa doa13 = new Doa();
        doa13.setNamaDoa("Doa Pengampunan Dosa 3");
        doa13.setBacaDoa("رَبِّ اغْفِرْ لِي وَتُبْ عَلَيَّ إِنَّكَ أَنْتَ التَّوَّابُ الرَّحِيمُ");
        doa13.setLatinDoa("RABBIGHFIRLII WA TUB 'ALAYYA, INNAKA ANTAT TAWWAABUR RAHIIM");
        doa13.setArtiDoa("Ya Tuhanku, ampunilah aku dan terimalah taubatku sesungguhnya Engkau adalah Dzat yang Maha menerima taubat lagi Maha Penyayang");
        doa13.setCarabacaDoa("-");
        doa13.setKeutamaanDoa("-");
        doa13.setSumberDoa("H.R. Bukhori 1516");
        doa13.setJenisDoa("Amalan Harian");
        db.doaDao().insertAll(doa13);


    }

}
