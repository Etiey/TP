from generic import RingElement

def create_Z_nZ(n: int):
    """Fabrique une classe représentant l'anneau Z/nZ."""
    if n <= 0:
        raise ValueError("Le module n doit être strictement positif.")

    class Z_nZ(RingElement):
        """Élément de l'anneau Z/nZ."""

        def __init__(self, value: int):
            self.value = value
            self_cannonical_rep=value % n

        @classmethod
        def zero(cls):
            return cls(0)

        @classmethod
        def one(cls):
            return cls(1)

        def __repr__(self):
            str_Z='['+str(self.value%n) + ']_'+str(n)
            print(str_Z)
            return str_Z

        def __eq__(self, other):
            return  (self.value-other.value) % n ==0

        def __add__(self, other):
            return Z_nZ((self.value+other.value) % n)

        def __neg__(self):
            return Z_nZ(-1*self.value)

        def __mul__(self, other):
            return Z_nZ((self.value*other.value)%n)


    return Z_nZ


if __name__ == "__main__":
    Z7 = create_Z_nZ(7)
    a = Z7(3)
    b = Z7(5)
    c = Z7(10)
    d = Z7(-2)
    zero = Z7.zero()
    one = Z7.one()

    # Représentation __repr__
    assert repr(a) == "[3]_7"
    assert repr(b) == "[5]_7"
    assert repr(c) == "[3]_7"
    assert repr(d) == "[5]_7"
    assert repr(zero) == "[0]_7"
    assert repr(one) == "[1]_7"

    # Égalité __eq__
    assert a == c
    assert b == d
    assert a != b
    assert zero != one

    # Addition __add__
    assert a + b == Z7(1)
    assert a + c == Z7(6)
    assert b + d == a
    assert a + zero == a
    assert b + one == Z7(6)

    # Opposé __neg__
    assert -a == Z7(4)
    assert -b == Z7(2)
    assert -zero == zero
    assert -one == Z7(6)

    # Multiplication __mul__
    assert a * b == Z7(1)
    assert a * c == Z7(2)
    assert b * d == Z7(4)
    assert a * one == a
    assert b * zero == zero

    print("Tous les tests ont réussi ✔️")
