package hu.tigra.pti.geb

import geb.Module

class Error extends Module {

    static url = "/index.php?controller=authentication"

    static at = {errorText.displayed}

    static content = {
        errorText { $('div[class="alert alert-danger"] p') }
    }


}

