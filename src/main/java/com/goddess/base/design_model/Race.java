package com.goddess.base.design_model;

/**
 * 建造者模式
 *
 * @author qinshengke
 * @since 2020/6/9 16:21
 **/

public class Race {
	private String name;
	private String feature;

	public Race(String name, String feature) {
		this.name = name;
		this.feature = feature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public static RaceBuilder builder() {
		return new RaceBuilder();
	}

	public static class RaceBuilder {
		private String name;
		private String feature;

		public RaceBuilder name(String name) {
			this.name = name;
			return this;
		}

		public RaceBuilder feature(String feature) {
			this.feature = feature;
			return this;
		}

		public Race build() {
			return new Race(this.name, this.feature);
		}

	}

}
