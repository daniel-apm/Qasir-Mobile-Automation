Feature: Authentikasi
  User ingin login ke dalam aplikasi Qasir

  @Positive
  Scenario Outline: Berhasil login ke dalam aplikasi Qasir
    Given User berada pada halaman pemilihan bahasa
    When User memilih bahasa Indonesia
    And User melakukan next pada setiap halaman Onboarding
    And User memasukkan akun credentials yang sudah didaftarkan
    And User memilih outlet <cabang>
    Then User berada pada halaman beranda

    Examples: 
      | cabang  			 |
      | Cabang Ciracas |