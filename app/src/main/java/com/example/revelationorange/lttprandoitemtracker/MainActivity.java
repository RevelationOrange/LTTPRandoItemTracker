package com.example.revelationorange.lttprandoitemtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private IconStateManager iconManager;
    private ArrayList<ImageButton> allButtons = new ArrayList<>();
    private ArrayList<ImageButton> allNoteButtons = new ArrayList<>();
    private ArrayList<Integer> prizeNotesIDs = new ArrayList<>();
    private int iconWidth, iconHeight;

    private static final String SHARED_PREFS = "shared_preferences";
    private final float MARKED_ALPHA = 1.0f, UNMARKED_ALPHA = 0.4f;
    private static int idStart = 100;
    private static int idCounter = idStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConstraintLayout trackerPanel;
        ConstraintSet cset = new ConstraintSet();
        ImageButton prevButton = null;
        int screenWidth, screenHeight, iconSizeRestriction, newRowCounter = 1, noteIndex = 0;
        final int maxIcons = 7;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // icon credit goes to crossproduct and halfarebel, I straight up just used the images
        // from their item/map tracker

        iconManager = new IconStateManager(sp);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        iconSizeRestriction = Math.min(screenWidth, screenHeight);
        iconWidth = (int) Math.floor(iconSizeRestriction / maxIcons);
        iconHeight = iconWidth;
        Bitmap bmp = ((BitmapDrawable) getDrawable(R.drawable.bomb)).getBitmap();
        Bitmap resized = Bitmap.createScaledBitmap(bmp, iconWidth, iconHeight, false);
        findViewById(R.id.resetButton).setBackground(new BitmapDrawable(getResources(), resized));

        prizeNotesIDs.add(14);
        prizeNotesIDs.add(21);
        prizeNotesIDs.add(28);
        prizeNotesIDs.add(35);
        prizeNotesIDs.add(36);
        prizeNotesIDs.add(37);
        prizeNotesIDs.add(38);
        prizeNotesIDs.add(39);
        prizeNotesIDs.add(40);
        prizeNotesIDs.add(41);

        trackerPanel = findViewById(R.id.trackerPanel);
        findViewById(R.id.mainLayout).setBackgroundColor(Color.parseColor("#101010"));
        for (int i = 0; i < iconManager.getNIcons(); i++) {
            ImageButton b = makeImgButton(this);

            bmp = ((BitmapDrawable) getDrawable(iconManager.getBackground(i))).getBitmap();
            resized = Bitmap.createScaledBitmap(bmp, iconWidth, iconHeight, false);

            b.setBackground(new BitmapDrawable(getResources(), resized));
//            b.setBackgroundResource(iconManager.getBackground(i));
            // setAlpha logic here
            b.setAlpha(iconManager.getAlpha(i) ? MARKED_ALPHA : UNMARKED_ALPHA);

            // set listeners here
            b.setOnClickListener(cycleIcons(b, i, false));
            b.setOnLongClickListener(resetIcon(b, i, false));

            trackerPanel.addView(b);
            cset.clone(trackerPanel);
            if (prevButton == null) {
                cset.connect(b.getId(), ConstraintSet.TOP, findViewById(R.id.resetButton).getId(), ConstraintSet.BOTTOM, 16*3);
                cset.connect(b.getId(), ConstraintSet.LEFT, trackerPanel.getId(), ConstraintSet.LEFT);
            }
            else {
                if (newRowCounter < maxIcons) {
                    cset.connect(b.getId(), ConstraintSet.TOP, prevButton.getId(), ConstraintSet.TOP);
                    cset.connect(b.getId(), ConstraintSet.LEFT, prevButton.getId(), ConstraintSet.RIGHT);
                    newRowCounter++;
                }
                else {
                    cset.connect(b.getId(), ConstraintSet.TOP, prevButton.getId(), ConstraintSet.BOTTOM);
                    cset.connect(b.getId(), ConstraintSet.LEFT, trackerPanel.getId(), ConstraintSet.LEFT);
                    newRowCounter = 1;
                }
            }
            cset.applyTo(trackerPanel);
            allButtons.add(b);

            if (prizeNotesIDs.contains(i)) {
                ImageButton noteButton = makeImgButton(this);
                bmp = ((BitmapDrawable) getDrawable(iconManager.getNoteBackground(noteIndex))).getBitmap();
                resized = Bitmap.createScaledBitmap(bmp, iconWidth/2, iconHeight/2, false);
                noteButton.setBackground(new BitmapDrawable(getResources(), resized));
                noteButton.setOnClickListener(cycleIcons(noteButton, noteIndex, true));
                noteButton.setOnLongClickListener(resetIcon(noteButton, noteIndex, true));
                trackerPanel.addView(noteButton);
                noteIndex++;

                cset.clone(trackerPanel);
                cset.connect(noteButton.getId(), ConstraintSet.BOTTOM, b.getId(), ConstraintSet.BOTTOM);
                cset.connect(noteButton.getId(), ConstraintSet.RIGHT, b.getId(), ConstraintSet.RIGHT);
                cset.applyTo(trackerPanel);
                allNoteButtons.add(noteButton);

                if (i == 40 || i == 41) {
                    ImageButton spellNoteButton = makeImgButton(this);
                    bmp = ((BitmapDrawable) getDrawable(iconManager.getNoteBackground(noteIndex))).getBitmap();
                    resized = Bitmap.createScaledBitmap(bmp, iconWidth/2, iconHeight/2, false);
                    spellNoteButton.setBackground(new BitmapDrawable(getResources(), resized));
                    spellNoteButton.setOnClickListener(cycleIcons(spellNoteButton, noteIndex, true));
                    spellNoteButton.setOnLongClickListener(resetIcon(spellNoteButton, noteIndex, true));
                    trackerPanel.addView(spellNoteButton);
                    noteIndex++;

                    cset.clone(trackerPanel);
                    cset.connect(spellNoteButton.getId(), ConstraintSet.BOTTOM, b.getId(), ConstraintSet.BOTTOM);
                    cset.connect(spellNoteButton.getId(), ConstraintSet.LEFT, b.getId(), ConstraintSet.LEFT);
                    cset.applyTo(trackerPanel);
                    allNoteButtons.add(spellNoteButton);
                }
            }

            prevButton = b;
        }
    }

    public void resetAll(View v) {
        for (int i = 0; i < allButtons.size(); i++) {
            int[] bga = iconManager.resetState(i);
            int bg = bga[0], alpha = bga[1];
            Bitmap bmp = ((BitmapDrawable) getDrawable(bg)).getBitmap();
            Bitmap resized = Bitmap.createScaledBitmap(bmp, iconWidth, iconHeight, false);
            allButtons.get(i).setBackground(new BitmapDrawable(getResources(), resized));
            allButtons.get(i).setAlpha(alpha == 0 ? UNMARKED_ALPHA : MARKED_ALPHA);
        }
        for (int i = 0; i < allNoteButtons.size(); i++) {
            int bg = iconManager.resetNoteState(i);
            Bitmap bmp = ((BitmapDrawable) getDrawable(bg)).getBitmap();
            Bitmap resized = Bitmap.createScaledBitmap(bmp, iconWidth/2, iconHeight/2, false);
            allNoteButtons.get(i).setBackground(new BitmapDrawable(getResources(), resized));
        }
    }

    View.OnClickListener cycleIcons(final ImageButton b, final int index, final boolean isNote) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bg, alpha, iw = iconWidth, ih = iconHeight;
                if (isNote) {
                    bg = iconManager.advNoteState(index);
                    alpha = 1;
                    iw /= 2;
                    ih /= 2;
                }
                else {
                    int[] bgAlpha = iconManager.advState(index);
                    bg = bgAlpha[0];
                    alpha = bgAlpha[1];
                }
                Bitmap bmp = ((BitmapDrawable) getDrawable(bg)).getBitmap();
                Bitmap resized = Bitmap.createScaledBitmap(bmp, iw, ih, false);
                b.setBackground(new BitmapDrawable(getResources(), resized));
                b.setAlpha(alpha == 0 ? UNMARKED_ALPHA : MARKED_ALPHA);
            }
        };
    }

    View.OnLongClickListener resetIcon(final ImageButton b, final int index, final boolean isNote) {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int bg, alpha, iw = iconWidth, ih = iconHeight;
                if (isNote) {
                    bg = iconManager.resetNoteState(index);
                    alpha = 1;
                    iw /= 2;
                    ih /= 2;
                }
                else {
                    int[] bga = iconManager.resetState(index);
                    bg = bga[0];
                    alpha = bga[1];
                }
                Bitmap bmp = ((BitmapDrawable) getDrawable(bg)).getBitmap();
                Bitmap resized = Bitmap.createScaledBitmap(bmp, iw, ih, false);
                b.setBackground(new BitmapDrawable(getResources(), resized));
                b.setAlpha(alpha == 0 ? UNMARKED_ALPHA : MARKED_ALPHA);
                return true;
            }
        };
    }

    protected void onDestroy() {
        for (int i = 0; i < iconManager.getNIcons(); i++) {
            sp.edit().putInt(Integer.toString(i), iconManager.getState(i)).commit();
        }
        super.onDestroy();
    }

    private static int getNextID() { return idCounter++; }

    private static ImageButton makeImgButton(Context c) {
        ImageButton retButton = new ImageButton(c);
        retButton.setId(getNextID());
        return retButton;
    }
}
