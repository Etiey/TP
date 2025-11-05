from generic import EuclideanRingElement
from bezout import extended_euclidean_algorithm
from typing import TypeVar, Type

A_Type = TypeVar("A_Type", bound=EuclideanRingElement)


def create_quotient_ring(A: Type[A_Type], p: A_Type):
    """Fabrique la classe représentant l’anneau quotient A/(p)."""

    class A_mod_p(A):
        """Élément de l’anneau quotient A/(p)."""

        def __init__(self, value):
            self.value = value

        @classmethod
        def zero(cls):
            raise NotImplementedError("À compléter !")

        @classmethod
        def one(cls):
            raise NotImplementedError("À compléter !")

        def __repr__(self):
            raise NotImplementedError("À compléter !")

        def __eq__(self, other):
            raise NotImplementedError("À compléter !")

        def __add__(self, other):
            raise NotImplementedError("À compléter !")

        def __neg__(self):
            raise NotImplementedError("À compléter !")

        def __mul__(self, other):
            raise NotImplementedError("À compléter !")

        def inverse(self):
            raise NotImplementedError("À compléter !")

    return A_mod_p


if __name__ == "__main__":
    from common_rings import Z

    Z5 = create_quotient_ring(Z, Z(5))
    assert Z5(Z(1)).inverse() == Z5(Z(1))
    assert Z5(Z(2)).inverse() == Z5(Z(3))
    assert Z5(Z(3)).inverse() == Z5(Z(2))
    assert Z5(Z(4)).inverse() == Z5(Z(4))

    from poly_division import create_euclidean_poly
    PolyZ5 = create_euclidean_poly(Z5)
    _p = PolyZ5(Z5(Z(1)), Z5(Z(1)), Z5(Z(1)))

    PolyZ5_mod_p = create_quotient_ring(PolyZ5, _p)

    _a = PolyZ5(Z5(Z(1)), Z5(Z(2)), Z5(Z(0)), Z5(Z(4)))
    _a_i = PolyZ5_mod_p(_a).inverse()
    assert (_a_i * PolyZ5_mod_p(_a)) == PolyZ5_mod_p.one()

    print("Tous les tests ont réussi ✔️")
