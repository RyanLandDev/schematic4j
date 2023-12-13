package net.sandrohc.schematic4j.schematic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import net.sandrohc.schematic4j.SchematicFormat;
import net.sandrohc.schematic4j.schematic.types.SchematicBiome;
import net.sandrohc.schematic4j.schematic.types.SchematicBlock;
import net.sandrohc.schematic4j.schematic.types.SchematicBlockEntity;
import net.sandrohc.schematic4j.schematic.types.SchematicEntity;
import net.sandrohc.schematic4j.schematic.types.SchematicItem;

/**
 * A generic schematic.
 */
public interface Schematic {

	/**
	 * The schematic format.
	 *
	 * @return the schematic format
	 */
	@NonNull SchematicFormat format();

	/**
	 * The width of the schematic, the X axis.
	 *
	 * @return the schematic width
	 */
	int width();

	/**
	 * The height of the schematic, the Y axis.
	 *
	 * @return the schematic height
	 */
	int height();

	/**
	 * The length of the schematic, the Z axis.
	 *
	 * @return the schematic length
	 */
	int length();

	/**
	 * The relative offset from the origin (0, 0, 0) of the schematic.
	 * <br>
	 * Values are stored in the format: [x, y, z]
	 *
	 * @return the schematic offset from the origin
	 */
	int[] offset();

	/**
	 * The block at the specified block.
	 * <p>
	 * Depending on the schematic format, each coordinate can also be negative and is relative to the schematic origin.
	 *
	 * @param x The X coordinate, can be a negative value
	 * @param y The X coordinate, can be a negative value
	 * @param z The X coordinate, can be a negative value
	 * @return block, or {@code null} if information is not available.
	 */
	@Nullable SchematicBlock block(int x, int y, int z);

	/**
	 * Iterator for iterating over the list of blocks.
	 *
	 * @return an iterator
	 */
	default @NonNull Iterator<SchematicBlock> blocks() {
		return Collections.emptyListIterator();
	}

	/**
	 * The list of tile/block entities, like chests and furnaces.
	 *
	 * @return list of block entities
	 */
	default @NonNull Iterator<SchematicBlockEntity> blockEntities() {
		return Collections.emptyListIterator();
	}

	/**
	 * The list of entities, like players.
	 *
	 * @return list of entities
	 */
	default @NonNull Iterator<SchematicEntity> entities() {
		return Collections.emptyListIterator();
	}

	/**
	 * The biome at the specified block.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 * @return biome, or {@code null} if information is not available.
	 */
	default @Nullable SchematicBiome biome(int x, int y, int z) {
		return null;
	}

	/**
	 * Iterator for iterating over the list of biomes.
	 *
	 * @return an iterator
	 */
	default @NonNull Iterator<SchematicBiome> biomes() {
		return Collections.emptyListIterator();
	}

	/**
	 * The name of the schematic.
	 *
	 * @return schematic name, or {@code null} if information is not available.
	 */
	default @Nullable String name() {
		return null;
	}

	/**
	 * The name of the author of the schematic.
	 *
	 * @return author, or {@code null} if information is not available.
	 */
	default @Nullable String author() {
		return null;
	}

	/**
	 * The date that this schematic was created on.
	 *
	 * @return creation date, or {@code null} if information is not available.
	 */
	default @Nullable LocalDateTime date() {
		return null;
	}

	/**
	 * The icon for representing this schematic. A Minecraft item.
	 *
	 * @return icon, or {@code null} if information is not available.
	 */
	default @Nullable SchematicItem icon() {
		return null;
	}

	/**
	 * The schematic format.
	 *
	 * @return the schematic format
	 * @deprecated Use {@link Schematic#format()} instead
	 */
	@Deprecated
	default SchematicFormat getFormat() {
		return format();
	}

	/**
	 * The width of the schematic.
	 *
	 * @return the schematic width
	 * @deprecated Use {@link Schematic#width()} instead
	 */
	@Deprecated
	default int getWidth() {
		return width();
	}

	/**
	 * The height of the schematic.
	 *
	 * @return the schematic height
	 * @deprecated Use {@link Schematic#height()} instead
	 */
	@Deprecated
	default int getHeight() {
		return height();
	}

	/**
	 * The length of the schematic.
	 *
	 * @return the schematic length
	 * @deprecated Use {@link Schematic#length()} instead
	 */
	@Deprecated
	default int getLength() {
		return length();
	}

	/**
	 * The relative offset from the origin (0, 0, 0) of the schematic.
	 * <br>
	 * Values are stored in the format: [x, y, z]
	 *
	 * @return the schematic offset from the origin
	 * @deprecated Use {@link Schematic#offset()} instead
	 */
	@Deprecated
	default int[] getOffset() {
		return offset();
	}

	/**
	 * The block at the specified block.
	 * <p>
	 * Depending on the schematic format, each coordinate can also be negative and is relative to the schematic origin.
	 *
	 * @param x The X coordinate, can be a negative value
	 * @param y The X coordinate, can be a negative value
	 * @param z The X coordinate, can be a negative value
	 * @return block, or {@code null} if information is not available.
	 * @deprecated Use {@link Schematic#block(int, int, int)} instead
	 */
	@Deprecated
	default SchematicBlock getBlock(int x, int y, int z) {
		return block(x, y, z);
	}

	/**
	 * Iterator for iterating over the list of blocks.
	 *
	 * @return an iterator
	 * @deprecated Use {@link Schematic#blocks()} instead
	 */
	@Deprecated
	default Iterator<SchematicBlock> getBlocks() {
		return blocks();
	}

	/**
	 * The list of tile/block entities, like chests and furnaces.
	 *
	 * @return list of block entities
	 * @deprecated Use {@link Schematic#blockEntities()} instead
	 */
	@Deprecated
	default Collection<SchematicBlockEntity> getBlockEntities() {
		final List<SchematicBlockEntity> items = new ArrayList<>();
		final Iterator<SchematicBlockEntity> iterator = blockEntities();
		while (iterator.hasNext()) {
			items.add(iterator.next());
		}
		return items;
	}

	/**
	 * The list of entities, like players.
	 *
	 * @return list of entities
	 * @deprecated Use {@link Schematic#entities()} instead
	 */
	@Deprecated
	default Collection<SchematicEntity> getEntities() {
		final List<SchematicEntity> items = new ArrayList<>();
		final Iterator<SchematicEntity> iterator = entities();
		while (iterator.hasNext()) {
			items.add(iterator.next());
		}
		return items;
	}

	/**
	 * The biome at the specified block.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 * @return biome, or {@code null} if information is not available.
	 * @deprecated Use {@link Schematic#biome(int, int, int)}  instead
	 */
	@Deprecated
	default SchematicBiome getBiome(int x, int y, int z) {
		return biome(x, y, z);
	}

	/**
	 * Iterator for iterating over the list of biomes.
	 *
	 * @return an iterator
	 * @deprecated Use {@link Schematic#biomes()} instead
	 */
	@Deprecated
	default Iterator<SchematicBiome> getBiomes() {
		return biomes();
	}

	/**
	 * The name of the schematic.
	 *
	 * @return schematic name, or {@code null} if information is not available.
	 * @deprecated Use {@link Schematic#name()}  instead
	 */
	@Deprecated
	default String getName() {
		return name();
	}
}
