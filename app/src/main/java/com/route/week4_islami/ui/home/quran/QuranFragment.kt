package com.route.week4_islami.ui.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View


import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.week4_islami.databinding.FragmentQuranBinding
import com.route.week4_islami.ui.Constants
import com.route.week4_islami.ui.suraDetails.ChapterDetailsActivity

class QuranFragment : Fragment() {
    lateinit var adapter: ChapterRecyclerAdapter
    lateinit var viewBinding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val view = inflater.inflate(
//            // xml file of fragment
//            R.layout.fragment_profile,
//            // container is a view in activity carries fragment
//            // <FrameLayout/>
//            container, false
//        )
        viewBinding = FragmentQuranBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChaptersRecycler()
    }

    val chaptersNames = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )

    private fun initChaptersRecycler() {
        adapter = ChapterRecyclerAdapter(chaptersNames)
        viewBinding.rvQuran.adapter = adapter
        adapter.onItemClickListener=
            ChapterRecyclerAdapter.OnItemClickListener{
                title , position ->  startSurahDetailsActivity(title ,position)
            }

    }

    private fun startSurahDetailsActivity(title: String, position: Int) {
        val intent =Intent(activity, ChapterDetailsActivity::class.java)
        intent.putExtra(Constants.CHAPTER_INDEX ,position+1)
        intent.putExtra(Constants.CHAPTER_TITLE ,title)
        startActivity(intent)
    }
}