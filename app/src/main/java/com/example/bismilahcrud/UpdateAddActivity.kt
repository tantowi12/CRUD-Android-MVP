package com.example.bismilahcrud

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bismilahcrud.model.DataItem
import com.example.bismilahcrud.presenter.CrudView
import com.example.bismilahcrud.presenter.Presenter
import kotlinx.android.synthetic.main.activity_update_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter
    @SuppressLint("SetText18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = Presenter(this)
        val itemData = intent.getSerializableExtra("dataItem")

        if (itemData == null) {
            btnAction.text = "Tambah"
            btnAction.onClick {
                presenter.addData(
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString())
            }
        } else if (itemData != null) {
            btnAction.text = "Update"
            val item = itemData as DataItem?
            etName.setText(item?.staffName.toString())
            etPhone.setText(item?.staffHp.toString())
            etAlamat.setText(item?.staffAlamat.toString())
            btnAction.onClick {
                presenter.updateData(
                    item?.staffId ?: "",
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString())

                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        startActivity<MainActivity>()
        finish()
    }

    override fun errorAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity<MainActivity>()
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessGet(data: String?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }

}