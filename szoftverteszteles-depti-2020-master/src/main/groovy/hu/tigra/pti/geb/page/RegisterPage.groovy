package hu.tigra.pti.geb.page

import geb.Page
import geb.module.RadioButtons

import java.awt.Checkbox

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        days { $('select[id="days"]')}
        months { $('select[id="months"]')}
        years { $('select[id="years"]')}
        newslatter { $('input[id="newsletter"]').module(geb.module.Checkbox)}
        optin { $('input[id="optin"]').module(geb.module.Checkbox) }
        register { $('button[id="submitAccount"]')}
    }
}
