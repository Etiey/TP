from generic import EuclideanRingElement


def extended_euclidean_algorithm(a: EuclideanRingElement, b: EuclideanRingElement):
    """Algorithme d’Euclide étendu.
    Retourne (g, u, v) tels que g = u·a + v·b.
    """
    raise NotImplementedError("À compléter !")


if __name__ == "__main__":
    from common_rings import Z

    _a, _b = Z(56), Z(15)
    _g, _u, _v = extended_euclidean_algorithm(_a, _b)
    assert _g == Z(1)
    assert (_u * _a + _v * _b) == _g

    print("Tous les tests ont réussi ✔️")
