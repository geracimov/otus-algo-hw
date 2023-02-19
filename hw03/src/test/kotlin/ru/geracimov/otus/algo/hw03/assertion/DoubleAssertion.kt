package ru.geracimov.otus.algo.hw03.assertion

import assertk.Assert
import assertk.assertions.isCloseTo


fun Assert<Double>.isCloseToWithDelta(value: Double, delta: Double = 0.0000000001) = isCloseTo(value, delta)