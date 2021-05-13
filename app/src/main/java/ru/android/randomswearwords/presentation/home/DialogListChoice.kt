package ru.android.randomswearwords.presentation.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.android.randomswearwords.base.FragmentListenerUtils
import ru.android.randomswearwords.presentation.SelectLanguage

class DialogListChoice : DialogFragment() {

    private lateinit var selectListener: SelectLanguage

    override fun onAttach(context: Context) {
        super.onAttach(context)
        selectListener =
            FragmentListenerUtils.getFragmentListener(this, SelectLanguage::class.java)
    }

    private val language = arrayOf("ru", "en", "it")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Select a language from the available")
                .setSingleChoiceItems(language, -1) { _, item ->

                    dialog?.dismiss()

                    selectListener.language(language[item])
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}