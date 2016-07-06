package com.company;
// Core calculations are done and seem to work!
// TODO: check assumptions, add units, docs, polish, diagrams, etc.

/*
    TODO: check the video comment section in a few days, to see if my questions were answered.
    Here's what I posted on 2016-7-5:
    -----------------------------------------------------------------------------------------------------------
        I'm trying to solve the problem, and have two questions. First, should we account for the thickness
    of the walls when calculating the number of encounters per second? I found several references to the
    nuclear radius relationship, but so far I can't tell if the calculated radius is based on the midpoints
    of the nucleons (the walls) or the exterior. The measurements seem to be based on scattering things off
    the surface, which in the macro-scale realm would find the exterior radius. Obviously a squishy, fuzzy,
    undulating nucleus is not a macro-scale sphere, but I can't figure out if that makes enough of a
    difference to justify disregarding the radius of the nucleons when talking about the radius of the
    nucleus. One source described how the protons are likely to be pushed to the outside of the nucleus,
    suggesting that the wall thickness will be even greater than the diameter of a nucleon, but I'm guessing
    that we don't need to account for that part. The diagram at 1:49 in the video suggests that we don't need
    to worry about the thickness (for the first part of the challenge), and just plug in the number from the
    nuclear radius relationship equation, but I'd like confirmation.

        Second, is it truly OK to treat the alpha particle as bouncing perfectly back & forth, in effect
    travelling the entire diameter of the interior on each cycle? On the macro scale, a marble bouncing around
    inside a balloon would almost never travel through the exact center. In some cases it might even get into
    a trajectory that keeps it rolling in continuous contact with the walls. Again, the diagram at 1:49 in the
    video suggests that we can use a very simple back & forth model, but I'd like confirmation that it's OK. I
    already know that quantum effects will make the behavior very different from a marble inside a balloon,
    but I don't know nearly enough to estimate those differences. Thanks in advance.﻿
    -----------------------------------------------------------------------------------------------------------

    Update: I posted some additional comments, largely in response to a guy named Gareth Dean. He addressed
    several of my questions by answering similar questions
 */

// TODO: for the bonus question, try using a barrier thickness of (nucleon_radius_femtometers * 2).
// TODO: finish adding an animated diagram (or give up and decide it's not worth it). See AnimationTimer, etc.

import java.util.stream.Stream;

public class Main {
    // Defined in the video
    public static final double PO212_NUCLEON_COUNT = 212;
    public static final double PO212_HALF_LIFE_MICROSEC = 0.3;
    public static final double ALPHA_KINETIC_ENERGY_MEV = 8.78;

    // Found online
    public static final double ALPHA_REST_MASS_MEV = 3727.379378;
    public static final double NUCLEON_RADIUS_FEMTOMETERS = 1.3;

    public static final double // TODO: convert to method in a Nucleus class
    velocity_from_ke_and_mass(double kinetic_energy, double mass) {
        return Math.sqrt((2 * kinetic_energy) / mass);
    }
    public static final double // TODO: convert to method in a Nucleus class
    nuclear_radius_femtometers(double nucleon_count) {
        return NUCLEON_RADIUS_FEMTOMETERS * Math.pow(nucleon_count, 1./3.);
    }
    public static void
    main(String[] args) {
        double velocity = velocity_from_ke_and_mass(ALPHA_KINETIC_ENERGY_MEV, ALPHA_REST_MASS_MEV);
        double diameter = nuclear_radius_femtometers(PO212_NUCLEON_COUNT) * 2;

        // TODO: fix units, check calculations, write unit tests, generalize.
        System.out.print((velocity * diameter) / PO212_HALF_LIFE_MICROSEC);
    }
}

/** This interface for objects that can be animated by an AnimationTimer */
// interface Animation { public void animate(); }
