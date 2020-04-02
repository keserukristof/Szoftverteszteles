package hu.tigra.pti.geb

class ErrorSpec extends BaseSpec {

    def 'Helytelen bejelentkezés'() {
        given: 'Megérkezünk a főoldalra.'
        MainPage mainPage = waitFor { to MainPage }

        when: 'Rákattintok a Sign in gombra.'
        mainPage.loginButton.click()

        then: 'Megérkezek a bejelentkező felületre.'
        LoginPage loginPage = waitFor { at LoginPage }
        loginPage.loginForm.displayed

        when: 'Kitöltöm a mezőket helytele adatokkal és rányomok a belépés gombra.'
        loginPage.emailAddress = 'pista.pista@pista.hu'
        loginPage.password = 'Nimda'
        loginPage.loginButton.click()

        then: 'Megjelenik a hibaüzenet'
        Error error = waitFor { at Error }
        error.errorText.text() == "There is 1 error"
    }
}