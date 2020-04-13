package io.github.orbitalno11.epoxy_example.epoxy.models

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide
import io.github.orbitalno11.epoxy_example.R
import kotlinx.android.synthetic.main.row_image_ratio.view.*

@ModelView(defaultLayout = R.layout.row_image_ratio, fullSpan = false)
class BannerEpoxy @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStylAttr: Int = 0
) : ConstraintLayout(context, attrs, defStylAttr) {

    @ModelProp
    fun setImageUrl(imageUrl: String?) {
        Glide.with(imageViewBanner)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.color.colorPrimary)
            .into(imageViewBanner)
    }

    @CallbackProp
    fun clickListener(listener: OnClickListener?) {
        setOnClickListener(listener)
    }
}