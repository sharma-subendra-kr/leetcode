// 1603. Design Parking System
// https://leetcode.com/problems/design-parking-system/

class ParkingSystem {
	int big, medium, small;

public:
	ParkingSystem(int big, int medium, int small) {
		this->big = big;
		this->medium = medium;
		this->small = small;
	}

	bool addCar(int carType) {
		if (carType == 1 && this->big > 0) {
			this->big--;
			return true;
		} else if (carType == 2 && this->medium > 0) {
			this->medium--;
			return true;
		} else if (carType == 3 && this->small > 0) {
			this->small--;
			return true;
		}
		return false;
	}
};