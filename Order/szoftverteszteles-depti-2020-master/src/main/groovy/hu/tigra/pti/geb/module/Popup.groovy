package hu.tigra.pti.geb.module

import geb.Module

class Popup extends Module {

    static content = {
        successful { navigator.find('div[class="layer_cart_product col-xs-12 col-md-6"] h2')}
    }
}
