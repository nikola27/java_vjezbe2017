package emailapp.bankaccountapp;
//ovo pravimo kao da uzimamo od njegdje drugdje, jer se rate ove uzimaju od drugih, ali ćemo pravit primjer
/*iz kojeg ćemo mi uzimati extract podatke
* , implementirali smo to u account,tj možemo koristiti u klasama
* napravit metode  ovdje gdje ćemo te rate, ili su to kamatna stopa*/
//ovo se inače radi negdje drugdje, podatke uzimamo drugdje
// ZOVEMO ovo INTERFACE

public interface IBaseRate {

    //pisanje metode koja vraća kamatnu stopu, u ovom slučaju npr kao neka banka koja daje neku osnocnu
    // kamatu kao, i an osnovu nje mi radimo svoju, ovdje će bit neki postotak te neke osnovne rate
        default double getBaseRate(){
        return 2.5;
        }
}
