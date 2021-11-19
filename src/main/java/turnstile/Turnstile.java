package turnstile;

import skipass.RegisterSystem;
import skipass.SkiPass;

public class Turnstile {

    private final RegisterSystem registerSystem = RegisterSystem.getRegisterSystem();

    // We scan the card and return true if it was successfully scanned and false if it wasn't
    public boolean scanSkiPass(SkiPass card){
        if (card.isActivated()) {
            card.use();
            boolean scan_res = card.checkIfUsable();
            if (scan_res) {
                System.out.println("Access granted for card no: " + card.getId());
                registerSystem.logEvent("Access granted for card no: " + card.getId());
                return true;
            }
            // Block Pass if not usable anymore
            registerSystem.blockSkiPass(card);
            registerSystem.logEvent("No more active card no: " + card.getId());
            return true;
        }
        System.out.println("Access DECLINED for card no: " + card.getId());
        registerSystem.logEvent("Access DECLINED for card no: " + card.getId());
        return false;
    }
}
