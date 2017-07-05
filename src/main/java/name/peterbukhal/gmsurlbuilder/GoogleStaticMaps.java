/*
 * Copyright 2015 Peter Bukhal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package name.peterbukhal.gmsurlbuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GoogleStaticMaps {

	private GoogleStaticMaps() {}

	public enum MapType {

		ROADMAP ("roadmap"),
		SATELLITE ("satellite"),
		HYBRID ("hybrid"),
		TERRAIN ("terrain");

		private String mapType;

		MapType(String mapType) {
			this.mapType = mapType;
		}

		@Override
		public String toString() {
			return mapType;
		}

	}

	public enum ScaleType {

		SCALE_1 (1),
		SCALE_2 (2),
		SCALE_4 (4);

		private int scale;

		ScaleType(int scale) {
			this.scale = scale;
		}

		@Override
		public String toString() {
			return String.valueOf(scale);
		}

	}

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

		ZoomLevel(int zoom) {
			this.zoom = zoom;
		}

		@Override
		public String toString() {
			return String.valueOf(zoom);
		}

	}

	public enum Format {

		PNG ("png"),
		JPEG ("jpeg"),
		GIF ("gif");

		private String format;

		Format(String format) {
			this.format = format;
		}

		@Override
		public String toString() {
			return format;
		}

	}

	public static final class Builder {

		private static final String API_URL = "maps.googleapis.com/maps/api/staticmap?";

		private static final String PARAM_CENTER = "center";
		private static final String PARAM_ZOOM = "zoom";
		private static final String PARAM_SIZE = "size";
		private static final String PARAM_SCALE = "scale";
		private static final String PARAM_FORMAT = "format";
		private static final String PARAM_MAPTYPE = "maptype";
		private static final String PARAM_LANGUAGE = "language";
		private static final String PARAM_REGION = "region";

		private static final String PARAM_CLIENT = "client";
		private static final String PARAM_SIGNATURE = "signature";
		private static final String PARAM_SENSOR = "sensor";
		private static final String PARAM_KEY = "key";
		private static final String PARAM_MARKERS = "markers";

		private Map<String, String> parameters = new HashMap<>();

		private boolean secured = true;

		/**
		 *
		 * @return
		 */
		public Builder withNotSecured() {
			this.secured = false;

			return this;
		}

		/**
		 *
		 *
		 * @param latitude
		 * @param longitude
		 * @return
		 */
		public Builder withCenter(double latitude, double longitude) {
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
		 * @param zoom
		 * @return
		 */
		public Builder withZoom(ZoomLevel zoom) {
			if (zoom == null)
				throw new IllegalArgumentException("ZoomLevel can't be null");

			parameters.put(PARAM_ZOOM, zoom.toString());

			return this;
		}

		/**
		 * Устанавливает размеры изображения карты.
		 *
		 * @param weight ширина
		 * @param height высота
		 * @return
		 */
		public Builder withSize(int weight, int height) {
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
		public Builder withScale(ScaleType scaleType) {
			if (scaleType == null)
				throw new IllegalArgumentException("ScaleType can't be null");

			parameters.put(PARAM_SCALE, scaleType.toString());

			return this;
		}

		/**
		 *
		 *
		 * @param format
		 * @return
		 */
		public Builder withFormat(Format format) {
			if (format == null)
				throw new IllegalArgumentException("Format can't be null");

			parameters.put(PARAM_FORMAT, format.toString());

			return this;
		}

		/**
		 *
		 *
		 * @param mapType
		 * @return
		 */
		public Builder withMapType(MapType mapType) {
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
		public Builder withLanguage(String language) {
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
		public Builder withRegion(String region) {
			if (region == null || region.isEmpty())
				throw new IllegalArgumentException("region can't be null or empty");

			parameters.put(PARAM_REGION, region);

			return this;
		}

		/**
		 *
		 *
		 * @param client
		 * @return
		 */
		public Builder withClient(String client) {
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
		public Builder withSignature(String signature) {
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
		public Builder withSensor(boolean sensor) {
			parameters.put(PARAM_SENSOR, String.valueOf(sensor));

			return this;
		}

		/**
		 *
		 *
		 * @param key
		 * @return
		 */
		public Builder withKey(String key) {
			if (key == null || key.isEmpty()) {
				throw new IllegalArgumentException("Api key can't be null or empty");
			}

			parameters.put(PARAM_KEY, key);

			return this;
		}

		private List<Marker> markers = new ArrayList<>();

		public Builder addMarker(Marker marker) {
			if (marker == null) {
				throw new IllegalArgumentException("Marker can't be null");
			}

			markers.add(marker);

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
			stringBuilder.append("&" + PARAM_MAPTYPE + "=" + parameters.get(PARAM_MAPTYPE));

			if (!markers.isEmpty()) {
				stringBuilder.append("&" + PARAM_MARKERS + "=");

				for (Marker marker : markers) {
					stringBuilder.append("icon:" + marker.getIcon() + "|" + marker.getLatitude() + "," + marker.getLongitude());
				}
			}

			return stringBuilder.toString();
		}

	}

}
