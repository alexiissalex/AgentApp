package com.example.agentapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agentapp.R
import com.example.agentapp.adapter.adt_rv
import com.example.agentapp.model.rv_data
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.kizitonwose.calendarview.utils.Size
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class DashboardFragment : Fragment() {

    private var selectedDate = LocalDate.now()
    private val dateFormatter = DateTimeFormatter.ofPattern("dd")
    private val dayFormatter = DateTimeFormatter.ofPattern("EEE")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dm = DisplayMetrics()
        val wm = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(dm)
        exSevenCalendar.apply {
            val dayWidth = dm.widthPixels / 7
            val dayHeight = (dayWidth * 1.25).toInt()
            daySize = Size(dayWidth, dayHeight)
        }

        class DayViewContainer(view: View) : ViewContainer(view) {
            val DateText = view.findViewById<TextView>(R.id.exSevenDateText)
            val DayText = view.findViewById<TextView>(R.id.exSevenDayText)
            val SelectedView = view.findViewById<View>(R.id.exSevenSelectedView)

            lateinit var day: CalendarDay
            init {
                view.setOnClickListener {
                    val firstDay = exSevenCalendar.findFirstVisibleDay()
                    val lastDay = exSevenCalendar.findLastVisibleDay()
                    if (firstDay == day) {
                        exSevenCalendar.smoothScrollToDate(day.date)
                    } else if (lastDay == day) {
                        exSevenCalendar.smoothScrollToDate(day.date.minusDays(4))
                    }


                    if (selectedDate != day.date) {
                        val oldDate = selectedDate
                        selectedDate = day.date
                        exSevenCalendar.notifyDateChanged(day.date)
                        oldDate?.let { exSevenCalendar.notifyDateChanged(it) }
                    }
                }
            }

            fun bind(day: CalendarDay) {
                this.day = day
                DateText.text = dateFormatter.format(day.date)
                DayText.text = dayFormatter.format(day.date)

                DateText.setTextColor(view.context.getColorCompat(if (day.date == selectedDate) R.color.blue else R.color.black))
                DayText.setTextColor(view.context.getColorCompat(if (day.date == selectedDate) R.color.blue else R.color.gray))
                SelectedView.isVisible = day.date == selectedDate
            }
        }

        exSevenCalendar.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) = container.bind(day)

        }

        val currentMonth = YearMonth.now()
        exSevenCalendar.setup(currentMonth, currentMonth.plusMonths(3), DayOfWeek.values().random())
        exSevenCalendar.scrollToDate(LocalDate.now())


        table_recycler_view.layoutManager = LinearLayoutManager(activity)
        val divItem = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        table_recycler_view.addItemDecoration(divItem)

        val rv_dataLists = mutableListOf<rv_data>()
        rv_dataLists.add(rv_data("AA Condo","13","30"))
        rv_dataLists.add(rv_data("BB Condo","10","20"))
        rv_dataLists.add(rv_data("CC Condo","13","20"))

        val adt = adt_rv(rv_dataLists)
        table_recycler_view.adapter = adt
    }

}