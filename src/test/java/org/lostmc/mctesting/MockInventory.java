package org.lostmc.mctesting;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class MockInventory implements Inventory {
    private final List<ItemStack> stacks = new ArrayList<>();

    @Override
    public ItemStack getItem(int index) {
        return stacks.get(index);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
        stacks.addAll(Arrays.asList(items));
        return new HashMap<>();
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        stacks.removeAll(Arrays.asList(items));
        return new HashMap<>();
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
       return first(material) != -1;
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        for (int i = 0; i < stacks.size(); i++) {
            if (stacks.get(i).getType() == material) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int getMaxStackSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMaxStackSize(int size) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setItem(int index, ItemStack item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemStack[] getContents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(int materialId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(ItemStack item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(int materialId, int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(ItemStack item, int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAtLeast(ItemStack item, int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int first(int materialId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int first(ItemStack item) {
        return 0;
    }

    @Override
    public int firstEmpty() {
        return 0;
    }

    @Override
    public void remove(int materialId) {

    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {

    }

    @Override
    public void remove(ItemStack item) {

    }

    @Override
    public void clear(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<HumanEntity> getViewers() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public InventoryType getType() {
        return null;
    }

    @Override
    public InventoryHolder getHolder() {
        return null;
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return null;
    }

    @Override
    public ListIterator<ItemStack> iterator(int index) {
        return null;
    }
}
