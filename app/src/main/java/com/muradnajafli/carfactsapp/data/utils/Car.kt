package com.muradnajafli.carfactsapp.data.utils


sealed class Car(val facts: List<String>) {

    data object BMW : Car(
        listOf(
            "BMW was founded in 1916 in Germany.",
            "The German translation of BMW is 'Bayerische Motoren Werke,' which means Bavarian Motor Works.",
            "BMW is known for manufacturing luxury cars and motorcycles.",
            "The headquarters of BMW is located in Munich, Germany.",
            "In 1972, BMW introduced its first 5 Series model.",
            "The slogan of BMW is 'Freude am Fahren,' which translates to 'Sheer Driving Pleasure.'",
            "In 1994, BMW launched its first SUV model, the BMW X5.",
            "BMW is also the owner of brands like Rolls-Royce and MINI.",
            "The M series of BMW represents its performance-oriented models.",
            "The BMW i8 model is a notable hybrid sports car.",
            "BMW has a significant focus on the development of electric vehicles.",
            "The company withdrew from Formula 1 racing in 2009.",
            "The BMW M1, introduced in 1978, was the brand's first supercar.",
            "The BMW E46, introduced in 2001, was a popular compact sedan.",
            "The BMW logo consists of blue and white colors, symbolizing a propeller blade.",
            "BMW often employs rear-wheel drive (RWD) systems in its cars.",
            "The 'iDrive' system in BMW vehicles controls multimedia and navigation.",
            "BMW has entered the electric vehicle market with models like the i4 and iX.",
            "The X6 model from BMW is a coupe-styled SUV.",
            "BMW is committed to sustainability, developing eco-friendly cars and initiatives."
        )
    )

    data object PORSCHE : Car(
        listOf(
            "Porsche is a German automobile manufacturer founded in 1931.",
            "Ferdinand Porsche, the founder, initially started as a motor vehicle development consultant.",
            "The company is known for high-performance sports cars, SUVs, and sedans.",
            "The iconic Porsche 911 was first introduced in 1963 and has become a symbol of the brand.",
            "Porsche's headquarters is located in Stuttgart, Germany.",
            "Porsche is part of the Volkswagen Group since 2012.",
            "The Porsche logo features a black prancing horse on a yellow shield, inspired by the city of Stuttgart's coat of arms.",
            "The Porsche 356, introduced in 1948, was the company's first production car.",
            "The Porsche 911 Turbo, introduced in 1974, is famous for its speed and distinctive design.",
            "Porsche's Cayenne model, introduced in 2002, marked the brand's entry into the SUV market.",
            "The company's mid-engine sports cars, like the Porsche Boxster and Cayman, offer a dynamic driving experience.",
            "Porsche's electric vehicle, the Taycan, was introduced in 2019, showcasing the brand's commitment to innovation.",
            "The 918 Spyder, introduced in 2013, is a hybrid supercar with impressive performance capabilities.",
            "Porsche has a rich motorsport history, participating in events like the 24 Hours of Le Mans and Formula E.",
            "The Porsche Panamera, introduced in 2009, is a luxury four-door sedan with a focus on performance.",
            "The Porsche Macan is a compact luxury SUV introduced in 2014.",
            "Porsche has a dedicated design studio called 'Porsche Design' that creates various products beyond automobiles.",
            "The 935, introduced in 1976, is a legendary race car known for its distinctive 'slantnose' design.",
            "Porsche is synonymous with precision engineering and a driver-centric approach.",
            "The brand continues to produce limited-edition models, emphasizing exclusivity and performance."
        )
    )

    companion object {
        fun fromString(carName: String): Car {
            return when (carName) {
                "BMW" -> BMW
                "Porsche" -> PORSCHE
                else -> throw IllegalArgumentException("Unknown car name")
            }
        }
    }

}