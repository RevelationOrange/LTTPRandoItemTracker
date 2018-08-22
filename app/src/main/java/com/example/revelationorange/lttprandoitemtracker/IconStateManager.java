package com.example.revelationorange.lttprandoitemtracker;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class IconStateManager {
    private ArrayList<Integer[]> iconBGs = new ArrayList<>();
    private ArrayList<Integer[]> noteIconBGs = new ArrayList<>();
    private ArrayList<Integer> iconStates = new ArrayList<>();

    IconStateManager(SharedPreferences sp) {
        this.iconBGs.add(new Integer[]{R.drawable.tunic1, R.drawable.tunic2, R.drawable.tunic3});
        this.iconBGs.add(new Integer[]{R.drawable.sword1, R.drawable.sword2, R.drawable.sword3, R.drawable.sword4});
        this.iconBGs.add(new Integer[]{R.drawable.bow0, R.drawable.bow1, R.drawable.bow2, R.drawable.bow3});
        this.iconBGs.add(new Integer[]{R.drawable.boomerang1, R.drawable.boomerang2, R.drawable.boomerang3});
        this.iconBGs.add(new Integer[]{R.drawable.hookshot});
        this.iconBGs.add(new Integer[]{R.drawable.mushroom});
        this.iconBGs.add(new Integer[]{R.drawable.powder});
        //
        this.iconBGs.add(new Integer[]{R.drawable.shield1, R.drawable.shield2, R.drawable.shield3});
        this.iconBGs.add(new Integer[]{R.drawable.moonpearl});
        this.iconBGs.add(new Integer[]{R.drawable.firerod});
        this.iconBGs.add(new Integer[]{R.drawable.icerod});
        this.iconBGs.add(new Integer[]{R.drawable.bombos});
        this.iconBGs.add(new Integer[]{R.drawable.ether});
        this.iconBGs.add(new Integer[]{R.drawable.quake});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss0});
        this.iconBGs.add(new Integer[]{R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.lantern});
        this.iconBGs.add(new Integer[]{R.drawable.hammer});
        this.iconBGs.add(new Integer[]{R.drawable.shovel});
        this.iconBGs.add(new Integer[]{R.drawable.net});
        this.iconBGs.add(new Integer[]{R.drawable.book});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss1});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.bottle0, R.drawable.bottle1, R.drawable.bottle2, R.drawable.bottle3, R.drawable.bottle4});
        this.iconBGs.add(new Integer[]{R.drawable.somaria});
        this.iconBGs.add(new Integer[]{R.drawable.byrna});
        this.iconBGs.add(new Integer[]{R.drawable.cape});
        this.iconBGs.add(new Integer[]{R.drawable.mirror});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss2});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.boots});
        this.iconBGs.add(new Integer[]{R.drawable.glove1, R.drawable.glove2});
        this.iconBGs.add(new Integer[]{R.drawable.flippers});
        this.iconBGs.add(new Integer[]{R.drawable.flute});
        this.iconBGs.add(new Integer[]{R.drawable.agahnim0, R.drawable.agahnim1});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss3});
        this.iconBGs.add(new Integer[]{R.drawable.boss4});
        this.iconBGs.add(new Integer[]{R.drawable.boss5});
        this.iconBGs.add(new Integer[]{R.drawable.boss6});
        this.iconBGs.add(new Integer[]{R.drawable.boss7});
        this.iconBGs.add(new Integer[]{R.drawable.boss8});
        this.iconBGs.add(new Integer[]{R.drawable.boss9});
        //
        this.iconBGs.add(new Integer[]{R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest6, R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconBGs.add(new Integer[]{R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});

        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize1, R.drawable.prize2, R.drawable.prize3, R.drawable.prize4});
        this.noteIconBGs.add(new Integer[]{R.drawable.medallion0, R.drawable.bombos, R.drawable.ether, R.drawable.quake});

        for (int i = 0; i < iconBGs.size(); i++) {
            iconStates.add(sp.getInt(Integer.toString(i), 0));
        }
    }

    public int getNIcons() { return this.iconBGs.size(); }

    public int getState(int index) { return this.iconStates.get(index); }

    public int getBackground(int index) { return this.iconBGs.get(index)[this.iconStates.get(index)]; }

    public int advState(int index) {
        int nextState = this.iconStates.get(index)+1;
        if (nextState == this.iconBGs.get(index).length) { nextState = 0; }
        this.iconStates.set(index, nextState);
        return nextState;
    }

    public int resetState(int index) {
        this.iconStates.set(index, 0);
        return this.iconBGs.get(index)[0];
    }
}
