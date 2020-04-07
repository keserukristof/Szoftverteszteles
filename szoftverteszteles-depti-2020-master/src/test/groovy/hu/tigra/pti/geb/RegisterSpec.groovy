package hu.tigra.pti.geb

import hu.tigra.pti.geb.page.LoginPage
import hu.tigra.pti.geb.page.RegisterPage

class RegisterSpec extends BaseSpec {

    def 'Regisztráció'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = 'dhfsssadshsf@email.hu'
        loginPage.registerButton.click()

        then: 'Megjelenik a "Create an account" űrlap.'
        def registerPage = waitFor { at RegisterPage }

        when: 'Kitöltöm a "Your personal information" blokkban az összes mezőt és a "Register" funkciógombra kattintok.'
        registerPage.gender.checked = 'Mr.'
        registerPage.firstName = 'Elek'
        registerPage.lastName = 'Teszt'
        registerPage.password = 'teszt123asds'
        registerPage.days = 1
        registerPage.months = 2
        registerPage.years = 1998
        registerPage.newslatter.check()
        registerPage.optin.check()
        registerPage.register.click()

        then: '5 hibaüzenet jelenik meg'
        registerPage.errors.size() == 5

        when: 'Kitöltöm a „Your address” blokkban az összes mezőt és „Register” funkciógombra kattintok.'
        registerPage.adressFirstName = 'Elek'
        registerPage.adressLastName = 'Teszt'
        registerPage.password = 'teszt123asds'
        registerPage.adress = 'Asd u. 77.'
        registerPage.city = 'Puspokladany'
        registerPage.state = 'Alabama'
        registerPage.postalCode = '41501'
        registerPage.country = 'United States'
        registerPage.mobilePhone = '06706666666'
        registerPage.alias = 'asd'
        registerPage.register.click()

        then: 'Megjelenik a felhasználó adatai felület: “My account”.'
        def myAccountPage = waitFor { at hu.tigra.pti.geb.page.MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }
}
