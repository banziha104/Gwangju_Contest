package com.nicname.iyeongjun.gwangju_contest.api.model.tour

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root
class TourModel {
    @Element
    var header: HeaderBean? = null
    @Element
    var body: BodyBean? = null

    @Root
    class HeaderBean {
        @Element
        var resultCode: String? = null
        @Element
        var resultMsg: String? = null
    }

    @Root
    class BodyBean {
        @Element
        var numOfRows: String? = null
        @Element
        var pageNo: String? = null
        @Element
        var totalCount: String? = null
        @ElementList
        var items: List<ItemBean>? = null

        @Root
        class ItemBean {
            @Element(required = false)
            var addr1: String? = null
            @Element(required = false)
            var addr2: String? = null
            @Element(required = false)
            var areacode: String? = null
            @Element(required = false)
            var cat1: String? = null
            @Element(required = false)
            var cat2: String? = null
            @Element(required = false)
            var cat3: String? = null
            @Element(required = false)
            var contentid: String? = null
            @Element(required = false)
            var contenttypeid: String? = null
            @Element(required = false)
            var createdtime: String? = null
            @Element(required = false)
            var dist: String? = null
            @Element(required = false)
            var firstimage: String? = null
            @Element(required = false)
            var firstimage2: String? = null
            @Element(required = false)
            var mapx: String? = null
            @Element(required = false)
            var mapy: String? = null
            @Element(required = false)
            var mlevel: String? = null
            @Element(required = false)
            var modifiedtime: String? = null
            @Element(required = false)
            var readcount: String? = null
            @Element(required = false)
            var sigungucode: String? = null
            @Element(required = false)
            var tel: String? = null
            @Element(required = false)
            var title: String? = null
            @Element(required = false)
            var booktour: String? = null
        }
    }
}
