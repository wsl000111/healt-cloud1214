(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["placeInfo"],{"0d63":function(t,s,a){"use strict";a.r(s);var n=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"placeInfo"},[a("div",{staticClass:"box"},[a("div",{staticClass:"title"},[t._v(t._s(t.info.name))]),a("div",{staticClass:"list"},t._l(t.info.datas,(function(s,n){return a("span",{key:n,staticClass:"row"},[t._v(t._s(n+1)+"."+t._s(s.ITEM_PACK_NAME))])})),0)]),""!=t.info.amount?a("div",{staticClass:"order"},[a("div",{staticClass:"cost"},[a("van-icon",{staticClass:"icon",attrs:{name:"shopping-cart"}}),a("div",{staticClass:"word"},[a("span",{staticClass:"over"},[t._v(t._s(t.info.amount))])])],1),a("div",{staticClass:"button",on:{click:t.toPlace}},[t._v("去预约")])]):a("van-button",{staticClass:"submit",attrs:{type:"info"},on:{click:t.toPlace}},[t._v("去预约")])],1)},i=[],o=(a("ac1f"),a("5319"),{name:"placeInfo",data:function(){return{info:{}}},components:{},mounted:function(){this.$route.params&&(this.info=this.$route.params),this.init()},methods:{init:function(){},toPlace:function(){var t=this;t.$router.replace({name:"place",params:{info:t.info}})}},computed:{},watch:{}}),c=o,e=(a("f9b6"),a("2877")),l=Object(e["a"])(c,n,i,!1,null,"09ebab23",null);s["default"]=l.exports},"2dbd":function(t,s,a){},f9b6:function(t,s,a){"use strict";a("2dbd")}}]);