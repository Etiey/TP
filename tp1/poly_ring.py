from generic import RingElement
from typing import TypeVar


A_Type = TypeVar("A_Type", bound=RingElement)


def create_poly_A(A: A_Type) -> type[A_Type]:
    """Fabrique une classe représentant l’anneau de polynômes A[X]."""

    class Poly(RingElement):
        """Élément de l’anneau A[X]."""

        def __init__(self, *coeffs: A):
            self.coeffs = coeffs

        @classmethod
        def zero(cls):
            """Polynôme nul."""
            raise NotImplementedError("À compléter !")

        @classmethod
        def one(cls):
            """Polynôme unité."""
            raise NotImplementedError("À compléter !")

        def __repr__(self):
            """Affichage lisible du polynôme."""
            raise NotImplementedError("À compléter !")

        def __eq__(self, other):
            """Égalité de polynômes."""
            raise NotImplementedError("À compléter !")

        def __add__(self, other):
            """Addition de deux polynômes."""
            raise NotImplementedError("À compléter !")

        def __neg__(self):
            """Opposé d’un polynôme."""
            raise NotImplementedError("À compléter !")

        def __mul__(self, other):
            """Multiplication de deux polynômes."""
            raise NotImplementedError("À compléter !")

    return Poly


if __name__ == "__main__":
    from zmodn import create_Z_nZ

    Z5 = create_Z_nZ(5)
    PolyZ5 = create_poly_A(Z5)

    P = PolyZ5(Z5(3), Z5(0), Z5(2))
    Q = PolyZ5(Z5(1), Z5(1))
    Z = PolyZ5(Z5(0), Z5(0), Z5(0))
    U = PolyZ5(Z5(1))
    C = PolyZ5(Z5(4))
    zero = PolyZ5.zero()
    one = PolyZ5.one()

    # Représentation __repr__
    assert repr(P) == "[3]_5 + [2]_5 X^2"
    assert repr(Q) == "[1]_5 + X"
    assert repr(Z) == "[0]_5"
    assert repr(U) == "[1]_5"
    assert repr(C) == "[4]_5"
    assert repr(zero) == "[0]_5"
    assert repr(one) == "[1]_5"

    # Égalité __eq__
    assert P == PolyZ5(Z5(3), Z5(0), Z5(2))
    assert P == PolyZ5(Z5(3), Z5(0), Z5(2), Z5(0), Z5(0))
    assert P != Q
    assert zero == Z
    assert one != zero

    # Addition __add__
    assert P + Q == PolyZ5(Z5(4), Z5(1), Z5(2))
    assert Q + P == P + Q
    assert P + zero == P
    assert zero + Q == Q
    assert PolyZ5(Z5(1)) + PolyZ5(Z5(4)) == zero

    # Opposé __neg__
    negP = -P
    assert -P == PolyZ5(Z5(2), Z5(0), Z5(3))
    assert P + (-P) == zero
    assert -zero == Z
    assert -one == PolyZ5(Z5(4))

    # Multiplication __mul__
    assert P * Q == PolyZ5(Z5(3), Z5(3), Z5(2), Z5(2))
    assert P * zero == zero
    assert P * one == P
    assert one * Q == Q
    assert Q * Q == PolyZ5(Z5(1), Z5(2), Z5(1))

    # --- Test degree ---
    assert P.degree() == 2
    assert Q.degree() == 1
    assert zero.degree() == float('-inf')
    assert one.degree() == 0

    print("Tous les tests ont réussi ✔️")
