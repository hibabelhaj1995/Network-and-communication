import random


def generera_frågor(tabel, ställda_frågor):    # Funktionen för att generera en ny fråga
    while True:
        faktor = random.randint(0, 12)
        fråga = f'{tabel} * {faktor} = '
        if fråga not in ställda_frågor:
            break
    ställda_frågor.append(fråga)    
    return fråga, faktor, tabel


def hantera_svar(svar, faktor, tabel):    # Funktionen för att kontrollera svar
    rätt_svar = faktor * tabel
    return svar == rätt_svar


def val_av_dörr(valde_dörren, antal_dörrar):    # Funktion för att välja dörr
    zombi_plats = random.randint(1, antal_dörrar)
    result = bool (valde_dörren == zombi_plats)
    return result, zombi_plats

print("******** HÄR KOMMER LITE INFORMATION OM SPELET ***********")
print("Spelet börjar med att användaren väljer en tabel sedan får \nen matematisk fråga som de måste svara rätt på. \nOm användaren svarar rätt, får de sedan välja en dörr bland flera dörrar. Bakom en av dessa dörrar finns en zombie,\noch användaren måste undvika att välja den dörren. \nOm de väljer rätt dörr fortsätter spelet, och de får en ny \nmatematisk fråga att svara på och välja en dörr igen. ")
print("*******************************************************")
print(" ")



while True:    # Första while loop för att att upprepa spelet om användaren vill spela igen 
    tabell = int(input('Välj tabell mellan 2 och 12: '))

    while (tabell < 2 or tabell > 12):    # Inmatning från användaren ska vara inom korrekt intervall.
        tabell = int(input('Ogiltigt val, vänligen välj en tabell mellan 2 och 12'))

    ställde_frågor = []    # Definera variabler
    antal_frågor = 0
    antal_dörrar = 12

    while True:
        ny_fråga, faktor, tabell = generera_frågor(tabell, ställde_frågor)    # Skapa en fråga och lägga den i en lista för att undvika repetera den
        svaret = int(input(ny_fråga))
        ställde_frågor.append(ny_fråga)

        if not hantera_svar(svaret, faktor, tabell):    # Programmet stoppar om fel svar anges
            print('Fel svar ;( lycka till nästa gång')
            break
        
        else:    # Öka antal frågor efter varje rätt svar
            print('BRA JOBBAT! nu till nästa steg')    

        
            välj_dörr = int(input(f'Välj gärna en dörr från 1 till {antal_dörrar}: '))
            träff, zombi_plats = val_av_dörr(välj_dörr, antal_dörrar)

    
            while (välj_dörr <= 0 or välj_dörr > antal_dörrar):    # Välj dörr inom korrekt intervall
                välj_dörr = int(input(f'FEL VAL! \n välj dörr mellan 1 och {antal_dörrar} '))
                träff, zombi_plats = val_av_dörr(välj_dörr, antal_dörrar)


            if träff:
                print('Du träffade zombi \n GAME OVER')
                break

    
            if antal_dörrar == 2:    # Svara på den sista fråga utan att behöva välja en dörr
                antal_frågor += 1
                print(f'BRA JOBBAT! Du är snart framme och har bara en fråga till !! \nTotal: {antal_frågor}')
                ny_fråga, faktor, tabell = generera_frågor(tabell, ställde_frågor)
                svaret = int(input(ny_fråga))
                if hantera_svar(svaret, faktor, tabell):
                    antal_frågor += 1
                    print(f"STORT GRATTIS \ndu har svarat rätt på {antal_frågor} frågor")
                    break

            else:
                antal_frågor += 1
                antal_dörrar -= 1
                print(f'BRA JOBBAT! Zombisarna var bakom dörr {zombi_plats} \nTotal: {antal_frågor} poäng')  
               
                if (antal_dörrar != 2):
                    print(f'Nu har du {antal_dörrar} dörrar kvar, FORTSÄTT!')

    spela_igen = input("Vill du spela igen? (ja/nej): ")
    if spela_igen != "ja":
        print("Tack för att du spelade. Hejdå!")
        break
