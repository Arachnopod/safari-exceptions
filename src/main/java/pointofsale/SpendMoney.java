package pointofsale;

import com.rs232.BaudRateException;
import com.rs232.CommsException;
import com.rs232.HWException;
import com.rs232.Modem;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SpendMoney {
  // Imagine lots of clients, in disparate parts of the software
  // i.e. it's not really right next to the the authorizePayment part!
  public void buy() {
    try {
      authorizePayement("1234567812345678", 50);
    } catch (BaudRateException e) {
      // configuration/protocol problem;
    } catch (CommsException e) {
      // io, retry
    } catch (HWException e) {
      // stuff broke, get new equipment
    }
  }

  private static boolean USE_MODEM = true;

  public int authorizePayement(String ccNum, int amount)
      throws BaudRateException, CommsException, HWException,
      IOException, UnknownHostException {
    Modem modem = new Modem();
    int triesRemaining = 3;
    boolean success = false;
    while (!success && triesRemaining > 0) {
      try {
        if (USE_MODEM) {
          modem.connect("1800USEVISA");
        } else {
          Socket s = new Socket("192.168.0.1", 8080);
        }
        success = true;
        // do other things here
      } catch (BaudRateException | CommsException | HWException ex) {
        if (--triesRemaining == 0) {
          throw ex;
        }
//      } catch (BaudRateException ex) {
//        if(--triesRemaining == 0) {
//          throw ex;
//        }
//      } catch (CommsException ex) {
//        if(--triesRemaining == 0) {
//          throw ex;
//        }
//      } catch (HWException ex) {
//        if(--triesRemaining == 0) {
//          throw ex;
//        }
//      }
      }
      return amount;
    }
  }
