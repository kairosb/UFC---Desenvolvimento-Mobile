package com.example.zooapp.models

import com.example.zooapp.R

data class Animal(
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val animalList = listOf(
    Animal(
        id = 1,
        name = "Tyrannosaurus Rex",
        species = "Tyrannosaurus rex",
        imageRes = R.drawable.tyrannosaurus_rex,
        description = "O T-Rex é um dos dinossauros mais conhecidos e temidos, sendo o rei dos predadores no seu tempo.",
        curiosities = "O T-Rex tinha dentes que podiam medir até 30 cm e uma mordida com força de 5 toneladas."
    ),
    Animal(
        id = 2,
        name = "Triceratops",
        species = "Triceratops horridus",
        imageRes = R.drawable.triceratops,
        description = "O Triceratops é conhecido por suas três grandes pontas e colar ósseo na cabeça.",
        curiosities = "Apesar de seu visual intimidador, acredita-se que o Triceratops era herbívoro e se alimentava de plantas baixas."
    ),
    Animal(
        id = 3,
        name = "Velociraptor",
        species = "Velociraptor mongoliensis",
        imageRes = R.drawable.velociraptor,
        description = "O Velociraptor era um dinossauro rápido e ágil, famoso por seu papel em caçadas em grupo.",
        curiosities = "Apesar de popularmente retratado como grande, o Velociraptor era do tamanho de um peru moderno."
    ),
    Animal(
        id = 4,
        name = "Brachiosaurus",
        species = "Brachiosaurus altithorax",
        imageRes = R.drawable.brachiosaurus,
        description = "O Brachiosaurus era um dos maiores dinossauros herbívoros, com um longo pescoço usado para alcançar as copas das árvores.",
        curiosities = "Este gigante pesava até 40 toneladas e tinha cerca de 25 metros de comprimento."
    ),
    Animal(
        id = 5,
        name = "Stegosaurus",
        species = "Stegosaurus stenops",
        imageRes = R.drawable.stegosaurus,
        description = "O Stegosaurus é conhecido por suas placas ósseas nas costas e um rabo com espinhos para defesa.",
        curiosities = "As placas do Stegosaurus podiam mudar de cor para regular sua temperatura ou para intimidar predadores."
    )
)
