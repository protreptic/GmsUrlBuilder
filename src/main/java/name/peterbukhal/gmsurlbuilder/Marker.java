package name.peterbukhal.gmsurlbuilder;

/**
 * Created by
 *
 * @author Peter Bukhal petr.bukhal <at> doconcall.ru
 *         on 05.07.2017.
 */
public final class Marker {

    private final String icon;
    private final double latitude;
    private final double longitude;

    public Marker(String icon, double latitude, double longitude) {
        this.icon = icon;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIcon() {
        return icon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
