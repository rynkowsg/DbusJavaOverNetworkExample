package info.rynkowski.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.freedesktop.Notifications;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;

public class NotificationsExample {
  private DBusConnection connection = null;

  private void openConnection(final String host, final String port) {
    try {
      String dbusAddress = "tcp:host=" + host + ",port=" + port;
      System.out.println("Connecting to: " + dbusAddress);
      connection = DBusConnection.getConnection(dbusAddress);
      System.out.println("D-Bus connection established successfully.");
    } catch (DBusException e) {
      e.printStackTrace();
      System.out.println("\"D-Bus connection hasn't established, connection: " + connection);
      connection = null;
    }
  }

  private void closeConnection() {
    if (connection != null) {
      connection.disconnect();
    }
    connection = null;
  }

  private void showNotification(final String summary, final String body, final int timeout) {
    if (connection != null) {
      try {
        // get remote object for Notifications
        Notifications notify = connection.getRemoteObject("org.freedesktop.Notifications",
            "/org/freedesktop/Notifications", Notifications.class);
        // set the rest of parameters
        String appName = "";
        String icon = "";
        UInt32 id = new UInt32(0);
        Map<String, Variant> hints = new HashMap<String, Variant>();
        hints.put("urgency", new Variant<Byte>((byte) 0));
        LinkedList<String> actions = new LinkedList<>();
        // call notify()
        notify.Notify(appName, id, icon, summary, body, actions, hints, timeout);
      } catch (DBusException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override public void run() {
        NotificationsExample app = new NotificationsExample();
        app.openConnection("192.168.1.112", "55555");
        app.showNotification("Remote Application", "This message is a test.", 10);
        app.closeConnection();
      }
    }).start();
  }
}
