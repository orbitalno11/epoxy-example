package io.github.orbitalno11.epoxy_example.epoxy

import android.util.Log
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import io.github.orbitalno11.epoxy_example.epoxy.models.BannerEpoxyModel_
import io.github.orbitalno11.epoxy_example.models.Banner
import kotlin.properties.Delegates
import kotlin.properties.Delegates.observable

class Controller : EpoxyController() {

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    var megaBanner by observable(null as Banner?) {_, _, _ -> requestModelBuild()}

    var horizontalBanners by observable(emptyList<Banner>()){_, _, _ -> requestModelBuild()}

    override fun buildModels() {
        // order view here !!
        // horizontal banner
        val banners = horizontalBanners.map {
            BannerEpoxyModel_()
                .id(it.id)
                .imageUrl(it.image)
                .clickListener { model, parentView, clickedView, position ->
                    Log.d("HORIZONTAL", "CLICK")
                }
        }

        CarouselModel_()
            .id("HORIZONTAL")
            .numViewsToShowOnScreen(3.1f)
            .paddingDp(15)
            .models(banners)
            .addIf(banners.isNotEmpty(), this)


        // megaBanner
        BannerEpoxyModel_()
            .id("MRGA_BANNER")
            .imageUrl(megaBanner?.image)
            .clickListener{ model, _, _, position ->
                Log.d("Controller", "Banner image: ${model.imageUrl()}")
            }
            .addTo(this)

    }
}