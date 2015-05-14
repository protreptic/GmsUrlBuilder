package org.javaprotrepticon.util.gmsurlbuilder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author petronic
 *
 */
public class GmsUrl {
	
	/**
	 * 
	 */
	private GmsUrl() {}
	
	/**
	 * @author petronic
	 *
	 */
	public enum MapType {
		
		ROADMAP 	("roadmap"), 
		SATELLITE 	("satellite"), 
		HYBRID 		("hybrid"), 
		TERRAIN 	("terrain");
		
		private String mapType;
		
		private MapType(String mapType) {
			this.mapType = mapType;
		}
		
		@Override
		public String toString() {
			return mapType;
		}
		
	}
	
	/**
	 * @author petronic
	 *
	 */
	public enum ScaleType {
		
		SCALE_1 (1), 
		SCALE_2 (2), 
		SCALE_4 (4);
		
		private int scale;
		
		private ScaleType(int scale) {
			this.scale = scale;
		}
		
		@Override
		public String toString() {
			return String.valueOf(scale);
		}
		
	}
	
	/**
	 * @author petronic
	 *
	 */
	public enum ZoomLevel {
		
		ZOOM_0 (0), 
		ZOOM_1 (1), 
		ZOOM_2 (2), 
		ZOOM_3 (3),
		ZOOM_4 (4), 
		ZOOM_5 (5), 
		ZOOM_6 (6), 
		ZOOM_7 (7),
		ZOOM_8 (8), 
		ZOOM_9 (9), 
		ZOOM_10 (10), 
		ZOOM_11 (11),
		ZOOM_12 (12), 
		ZOOM_13 (13), 
		ZOOM_14 (14), 
		ZOOM_15 (15),
		ZOOM_16 (16), 
		ZOOM_17 (17),
		ZOOM_18 (18), 
		ZOOM_19 (19), 
		ZOOM_20 (20), 
		ZOOM_21 (21);
		
		private int zoom;
		
		private ZoomLevel(int zoom) {
			this.zoom = zoom;
		}
		
		@Override
		public String toString() {
			return String.valueOf(zoom);
		}
		
	}
	
	/**
	 * @author petronic
	 *
	 */
	public enum PictureFormat {
		
		PNG ("png"), 
		JPEG ("jpeg"), 
		GIF ("gif");
		
		private String format;
		
		private PictureFormat(String format) {
			this.format = format;
		}
		
		@Override
		public String toString() {
			return format;
		}
		
	}
	
	/**
	 * @author petronic
	 *
	 */
	public static class Builder {
		
		private static final String API_URL = "maps.googleapis.com/maps/api/staticmap?";
		
		private static final String PARAM_CENTER 	= "center";
		private static final String PARAM_ZOOM 		= "zoom";
		private static final String PARAM_SIZE 		= "size";
		private static final String PARAM_SCALE 	= "scale";
		private static final String PARAM_FORMAT 	= "format";
		private static final String PARAM_MAPTYPE 	= "maptype";
		private static final String PARAM_LANGUAGE 	= "language";
		private static final String PARAM_REGION 	= "region";
		
		private static final String PARAM_CLIENT 	= "client";
		private static final String PARAM_SIGNATURE = "signature";
		private static final String PARAM_SENSOR 	= "sensor";
		private static final String PARAM_KEY 		= "key";
		
		private Map<String, String> parameters = new HashMap<String, String>();
		
		private boolean secured = true;
		
		/**
		 * 
		 * 
		 * @param secured
		 * 
		 * @return
		 */
		public Builder setSecured(boolean secured) {
			this.secured = secured;
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param center
		 * @return
		 */
		public Builder setCenter(String center) {
			if (center == null || center.isEmpty()) 
				throw new IllegalArgumentException("Center query string can't be null or empty");
			
			parameters.put(PARAM_CENTER, center);
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param latitude
		 * @param longitude
		 * @return
		 */
		public Builder setCenter(double latitude, double longitude) {
			if (latitude > 90 || latitude < -90)
				throw new IllegalArgumentException("latitude value must be between -90 and 90");
			if (longitude > 180 || longitude < -180)
				throw new IllegalArgumentException("longitude value must be between -180 and 180");	
			
			parameters.put(PARAM_CENTER, latitude + "," + longitude);
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param zoomLevel
		 * @return
		 */
		public Builder setZoom(ZoomLevel zoomLevel) {
			if (zoomLevel == null) 
				throw new IllegalArgumentException("ZoomLevel can't be null");
			
			parameters.put(PARAM_ZOOM, zoomLevel.toString()); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param weight
		 * @param height
		 * @return
		 */
		public Builder setSize(int weight, int height) {
			if (weight <= 0 || height <= 0) 
				throw new IllegalArgumentException("weight or height can't be negative or zero");
			
			parameters.put(PARAM_SIZE, weight + "x" + height); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param scaleType
		 * @return
		 */
		public Builder setScale(ScaleType scaleType) {
			if (scaleType == null) 
				throw new IllegalArgumentException("ScaleType can't be null");
			
			parameters.put(PARAM_SCALE, scaleType.toString()); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param pictureFormat
		 * @return
		 */
		public Builder setFormat(PictureFormat pictureFormat) {
			if (pictureFormat == null) 
				throw new IllegalArgumentException("PictureFormat can't be null");
			
			parameters.put(PARAM_FORMAT, pictureFormat.toString()); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param mapType
		 * @return
		 */
		public Builder setMapType(MapType mapType) {
			if (mapType == null) 
				throw new IllegalArgumentException("MapType can't be null");
			
			parameters.put(PARAM_MAPTYPE, mapType.toString()); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param language
		 * @return
		 */
		public Builder setLanguage(String language) {
			if (language == null || language.isEmpty()) 
				throw new IllegalArgumentException("language can't be null or empty");
			
			parameters.put(PARAM_LANGUAGE, language); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param region
		 * @return
		 */
		public Builder setRegion(String region) {
			if (region == null || region.isEmpty()) 
				throw new IllegalArgumentException("region can't be null or empty");
			
			parameters.put(PARAM_REGION, region); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param locale
		 * @return
		 */
		public Builder setLocale(Locale locale) {
			if (locale == null) 
				throw new IllegalArgumentException("Locale can't be null");
			
			parameters.put(PARAM_LANGUAGE, locale.getLanguage()); 
			parameters.put(PARAM_REGION, locale.getCountry()); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param client
		 * @return
		 */
		public Builder setClient(String client) {
			if (client == null || client.isEmpty()) 
				throw new IllegalArgumentException("client can't be null or empty");
			
			parameters.put(PARAM_CLIENT, client); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param signature
		 * @return
		 */
		public Builder setSignature(String signature) {
			if (signature == null || signature.isEmpty()) 
				throw new IllegalArgumentException("signature can't be null or empty");
			
			parameters.put(PARAM_SIGNATURE, signature); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param sensor
		 * @return
		 */
		public Builder setSensor(boolean sensor) {
			parameters.put(PARAM_SENSOR, String.valueOf(sensor)); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @param key
		 * @return
		 */
		public Builder setKey(String key) {
			if (key == null || key.isEmpty()) 
				throw new IllegalArgumentException("Api key can't be null or empty");
			
			parameters.put(PARAM_KEY, key); 
			
			return this;
		}
		
		/**
		 * 
		 * 
		 * @return
		 */
		public String build() {
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append((secured ? "https://" : "http://") + API_URL); 
			
			
			stringBuilder.append(PARAM_CENTER + "=" + parameters.get(PARAM_CENTER));
			stringBuilder.append("&" + PARAM_ZOOM + "=" + parameters.get(PARAM_ZOOM));
			stringBuilder.append("&" + PARAM_SIZE + "=" + parameters.get(PARAM_SIZE));
			stringBuilder.append("&" + PARAM_SCALE + "=" + parameters.get(PARAM_SCALE));
			stringBuilder.append("&" + PARAM_SENSOR + "=" + parameters.get(PARAM_SENSOR));
			stringBuilder.append("&" + PARAM_LANGUAGE + "=" + parameters.get(PARAM_LANGUAGE));
			stringBuilder.append("&" + PARAM_REGION + "=" + parameters.get(PARAM_REGION));
			stringBuilder.append("&" + PARAM_KEY + "=" + parameters.get(PARAM_KEY));
			
			return stringBuilder.toString();
		}
		
	}
	
}
