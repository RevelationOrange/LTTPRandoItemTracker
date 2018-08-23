package com.example.revelationorange.lttprandoitemtracker;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class IconStateManager {
    private ArrayList<Boolean[]> iconAlphas = new ArrayList<>();
    private ArrayList<Integer[]> iconBGs = new ArrayList<>();
    private ArrayList<Integer[]> noteIconBGs = new ArrayList<>();
    private ArrayList<Integer> iconStates = new ArrayList<>();
    private ArrayList<Integer> noteIconStates = new ArrayList<>();

    IconStateManager(SharedPreferences sp) {
        this.iconBGs.add(new Integer[]{R.drawable.tunic1, R.drawable.tunic2, R.drawable.tunic3});
        this.iconAlphas.add(new Boolean[]{true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.sword1, R.drawable.sword1, R.drawable.sword2, R.drawable.sword3, R.drawable.sword4});
        this.iconAlphas.add(new Boolean[]{false, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.bow0, R.drawable.bow0, R.drawable.bow1, R.drawable.bow2, R.drawable.bow3});
        this.iconAlphas.add(new Boolean[]{false, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.boomerang1, R.drawable.boomerang1, R.drawable.boomerang2, R.drawable.boomerang3});
        this.iconAlphas.add(new Boolean[]{false, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.hookshot, R.drawable.hookshot});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.mushroom, R.drawable.mushroom});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.powder, R.drawable.powder});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.shield1, R.drawable.shield1, R.drawable.shield2, R.drawable.shield3});
        this.iconAlphas.add(new Boolean[]{false, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.moonpearl, R.drawable.moonpearl});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.firerod, R.drawable.firerod});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.icerod, R.drawable.icerod});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.bombos, R.drawable.bombos});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.ether, R.drawable.ether});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.quake, R.drawable.quake});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss0, R.drawable.boss0});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.lantern, R.drawable.lantern});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.hammer, R.drawable.hammer});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.shovel, R.drawable.shovel});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.net, R.drawable.net});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.book, R.drawable.book});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss1, R.drawable.boss1});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.bottle0, R.drawable.bottle1, R.drawable.bottle2, R.drawable.bottle3, R.drawable.bottle4});
        this.iconAlphas.add(new Boolean[]{false, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.somaria, R.drawable.somaria});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.byrna, R.drawable.byrna});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.cape, R.drawable.cape});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.mirror, R.drawable.mirror});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss2, R.drawable.boss2});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.boots, R.drawable.boots});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.glove1, R.drawable.glove1, R.drawable.glove2});
        this.iconAlphas.add(new Boolean[]{false, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.flippers, R.drawable.flippers});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.flute, R.drawable.flute});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.agahnim0, R.drawable.agahnim1});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.boss3, R.drawable.boss3});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss4, R.drawable.boss4});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss5, R.drawable.boss5});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss6, R.drawable.boss6});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss7, R.drawable.boss7});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss8, R.drawable.boss8});
        this.iconAlphas.add(new Boolean[]{false, true});
        this.iconBGs.add(new Integer[]{R.drawable.boss9, R.drawable.boss9});
        this.iconAlphas.add(new Boolean[]{false, true});
        //
        this.iconBGs.add(new Integer[]{R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest6, R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true});
        this.iconBGs.add(new Integer[]{R.drawable.chest5, R.drawable.chest4, R.drawable.chest3, R.drawable.chest2, R.drawable.chest1, R.drawable.chest0});
        this.iconAlphas.add(new Boolean[]{true, true, true, true, true, true});

        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.medallion0, R.drawable.bombos, R.drawable.ether, R.drawable.quake});
        this.noteIconBGs.add(new Integer[]{R.drawable.prize0, R.drawable.prize3, R.drawable.prize4, R.drawable.prize2, R.drawable.prize1});
        this.noteIconBGs.add(new Integer[]{R.drawable.medallion0, R.drawable.bombos, R.drawable.ether, R.drawable.quake});

        for (int i = 0; i < iconBGs.size(); i++) {
            iconStates.add(sp.getInt(Integer.toString(i), 0));
        }
        for (int i = 0; i < noteIconBGs.size(); i++) {
            noteIconStates.add(sp.getInt(Integer.toString(iconBGs.size()+i), 0));
        }
    }

    public int getNIcons() { return this.iconBGs.size(); }
    public int getNNoteIcons() { return this.noteIconBGs.size(); }

    public int getState(int index) { return this.iconStates.get(index); }
    public int getNoteState(int index) { return this.noteIconStates.get(index); }

    public int getBackground(int index) { return this.iconBGs.get(index)[this.iconStates.get(index)]; }
    public int getNoteBackground(int index) { return this.noteIconBGs.get(index)[this.noteIconStates.get(index)]; }

    public boolean getAlpha(int index) { return this.iconAlphas.get(index)[this.iconStates.get(index)]; }

    public int[] advState(int index) {
        int nextState = this.iconStates.get(index)+1;
        int retAlpha;
        if (nextState == this.iconBGs.get(index).length) { nextState = 0; }
        this.iconStates.set(index, nextState);
        retAlpha = this.iconAlphas.get(index)[nextState] ? 1 : 0;
        return new int[]{this.iconBGs.get(index)[this.iconStates.get(index)], retAlpha};
    }
    public int advNoteState(int index) {
        int nextState = this.noteIconStates.get(index)+1;
        if (nextState == this.noteIconBGs.get(index).length) { nextState = 0; }
        this.noteIconStates.set(index, nextState);
        return this.noteIconBGs.get(index)[this.noteIconStates.get(index)];
    }

    public int[] resetState(int index) {
        int retAlpha;
        this.iconStates.set(index, 0);
        retAlpha = this.iconAlphas.get(index)[0] ? 1 : 0;
        return new int[]{this.iconBGs.get(index)[0], retAlpha};
    }
    public int resetNoteState(int index) {
        this.noteIconStates.set(index, 0);
        return this.noteIconBGs.get(index)[0];
    }
}
