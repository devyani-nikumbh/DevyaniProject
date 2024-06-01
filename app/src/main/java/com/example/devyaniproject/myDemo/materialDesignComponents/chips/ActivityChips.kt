package com.example.devyaniproject.myDemo.materialDesignComponents.chips

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.devyaniproject.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup


class ActivityChips : AppCompatActivity() {
    private val TAG = "Chips Example"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chips)

        /*Action chip section*/
        val actionChip = findViewById<Chip>(R.id.action_chip)
        actionChip.setOnClickListener { Log.i(TAG, "Clicked action chip") }

        /*Entry chip section*/
        val entryChipGroup = findViewById<ChipGroup>(R.id.entry_chip_group)
        val entryChip = getChip(entryChipGroup, "Hello World")
        val entryChip2 = getChip(entryChipGroup, "Test")
        entryChipGroup.addView(entryChip)
        entryChipGroup.addView(entryChip2)

        /*Filter Chip section*/
        val filterChipGroup = findViewById<ChipGroup>(R.id.filter_chip_group)
        val filterChip = findViewById<Chip>(R.id.filter_chip)
        val filterChip2 = findViewById<Chip>(R.id.filter_chip2)
        val filterChipListener =
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                Log.i(
                    TAG,
                    buttonView.id.toString() + ""
                )
            }
        filterChip.setOnCheckedChangeListener(filterChipListener)
        filterChip2.setOnCheckedChangeListener(filterChipListener)

        /*Filter Chip section - Single selection mode*/
        val filterChipGroupSingleSelection = findViewById<ChipGroup>(R.id.filter_chip_SS_group)
        filterChipGroupSingleSelection.setOnCheckedChangeListener { group, checkedId -> // Handle the checked chip change.
            Log.i(TAG, "ID: " + group.checkedChipId)
        }

        /*Choice Chip Section*/
        val choiceChipGroup = findViewById<ChipGroup>(R.id.choice_chip_group)
        choiceChipGroup.setOnCheckedChangeListener { chipGroup, i ->
            Log.i(
                TAG,
                i.toString() + ""
            )
        }
    }

    private fun getChip(entryChipGroup: ChipGroup, text: String): Chip {
        val chip = Chip(this)
        chip.setChipDrawable(ChipDrawable.createFromResource(this, R.xml.my_chip))
        val paddingDp = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 10f,
            getResources().displayMetrics
        ).toInt()
        chip.setPadding(paddingDp, paddingDp, paddingDp, paddingDp)
        chip.text = text
        chip.setOnCloseIconClickListener { entryChipGroup.removeView(chip) }
        return chip
    }
}