package com.ayush.dependencyinjection;

import javax.inject.Inject;

public class Target {
    @Inject
    @Favourites
    Subject maths;
}
