package net.coderbot.iris.gl.uniform;

import com.mojang.math.Matrix4f;
import net.coderbot.iris.vendored.joml.Vector2f;
import net.coderbot.iris.vendored.joml.Vector2i;
import net.coderbot.iris.vendored.joml.Vector3d;
import net.coderbot.iris.vendored.joml.Vector3f;
import net.coderbot.iris.vendored.joml.Vector4f;

import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public interface LocationalUniformHolder extends UniformHolder {
	LocationalUniformHolder addUniform(UniformUpdateFrequency updateFrequency, Uniform uniform);

	OptionalInt location(String name, UniformType type);

	@Override
	default LocationalUniformHolder uniform1f(UniformUpdateFrequency updateFrequency, String name, FloatSupplier value) {
		location(name, UniformType.FLOAT).ifPresent(id -> addUniform(updateFrequency, new FloatUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform1f(UniformUpdateFrequency updateFrequency, String name, IntSupplier value) {
		location(name, UniformType.FLOAT).ifPresent(id -> addUniform(updateFrequency, new FloatUniform(id, () -> (float) value.getAsInt())));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform1f(UniformUpdateFrequency updateFrequency, String name, DoubleSupplier value) {
		location(name, UniformType.FLOAT).ifPresent(id -> addUniform(updateFrequency, new FloatUniform(id, () -> (float) value.getAsDouble())));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform1i(UniformUpdateFrequency updateFrequency, String name, IntSupplier value) {
		location(name, UniformType.INT).ifPresent(id -> addUniform(updateFrequency, new IntUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform1b(UniformUpdateFrequency updateFrequency, String name, BooleanSupplier value) {
		location(name, UniformType.INT).ifPresent(id -> addUniform(updateFrequency, new BooleanUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform2f(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector2f> value) {
		location(name, UniformType.VEC2).ifPresent(id -> addUniform(updateFrequency, new Vector2Uniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform2i(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector2i> value) {
		location(name, UniformType.VEC2I).ifPresent(id -> addUniform(updateFrequency, new Vector2IntegerJomlUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform3f(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector3f> value) {
		location(name, UniformType.VEC3).ifPresent(id -> addUniform(updateFrequency, new Vector3Uniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniformVanilla3f(UniformUpdateFrequency updateFrequency, String name, Supplier<com.mojang.math.Vector3f> value) {
		location(name, UniformType.VEC3).ifPresent(id -> addUniform(updateFrequency, new VanillaVector3Uniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniformTruncated3f(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector4f> value) {
		location(name, UniformType.VEC3).ifPresent(id -> addUniform(updateFrequency, Vector3Uniform.truncated(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform3d(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector3d> value) {
		location(name, UniformType.VEC3).ifPresent(id -> addUniform(updateFrequency, Vector3Uniform.converted(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform4f(UniformUpdateFrequency updateFrequency, String name, Supplier<Vector4f> value) {
		location(name, UniformType.VEC4).ifPresent(id -> addUniform(updateFrequency, new Vector4Uniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniform4fArray(UniformUpdateFrequency updateFrequency, String name, Supplier<float[]> value) {
		location(name, UniformType.VEC4).ifPresent(id -> addUniform(updateFrequency, new Vector4ArrayUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniformMatrix(UniformUpdateFrequency updateFrequency, String name, Supplier<Matrix4f> value) {
		location(name, UniformType.MAT4).ifPresent(id -> addUniform(updateFrequency, new MatrixUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniformJomlMatrix(UniformUpdateFrequency updateFrequency, String name, Supplier<net.coderbot.iris.vendored.joml.Matrix4f> value) {
		location(name, UniformType.MAT4).ifPresent(id -> addUniform(updateFrequency, new JomlMatrixUniform(id, value)));

		return this;
	}

	@Override
	default LocationalUniformHolder uniformMatrixFromArray(UniformUpdateFrequency updateFrequency, String name, Supplier<float[]> value) {
		location(name, UniformType.MAT4).ifPresent(id -> addUniform(updateFrequency, new MatrixFromFloatArrayUniform(id, value)));

		return this;
	}
}
